
/**
 * Method test
 */
public void fluxTest {
    Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
        .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
        .concatWith(Flux.just("After Error"))
        .log();

    stringFlux.subscribe(System.out::println, 
        (e) -> System.err.println("Exception is " + e),
        () -> System.out.println("Completed"))
}

public void fluxTestElements_WithoutError() {
    Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
        .log();
    
    // order matters
    StepVerifier.create(stringFlux)
        .expectNext("Spring")
        .expectNext("Spring Boot")
        .expectNext("Reactive Spring")
        .verifyComplete();
}

public void fluxTestElements_WithError() {
    Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
        .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
        .log();

    StepVerifier.create(stringFlux)
        .expectNext("Spring")
        .expectNext("Spring Boot")
        .expectNext("Reactive Spring")
        //.expectError(RuntimeException.class) // cannot have both
        .expectErrorMessage("Exception Occurred")
        .verify(); // verify all lifecycle
}

public void fluxTestElementsCount_WithError() {
    Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
        .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
        .log();

    StepVerifier.create(stringFlux)
        .expectNextCount(3)
        //.expectError(RuntimeException.class) // cannot have both
        .expectErrorMessage("Exception Occurred")
        .verify();
}

public void fluxTestElements_WithError1() {
    Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
        .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
        .log();

    StepVerifier.create(stringFlux)
        .expectNext("Spring", "Spring Boot", "Reactive Spring")
        .expectErrorMessage("Exception Occurred")
        .verify();
}


public void monoTest() {
    Mono<String> stringMono = Mono.just("Spring")
        .log();
    
    StepVerifier.create(stringMono)
        expectNext("Spring")
        .verifyComplete();
}

public void monoTest_Error() {
    Mono<String> stringMono = Mono.error(new RuntimeException("Exception Occurred"))
        .log();
    
    StepVerifier.create(stringMono)
        expectError(RuntimeException.class)
        .verify();
}

/**
 * Controller test
 */
@RestController
public class FluxAndMonoController() {
    
    @GetMapping("/flux")
    public Flux<Integer> returnFlux() {
        return Flux.just(1,2,3,4)
            .delayElements(Duration.ofSeconds(1))
            .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> returnFluxStream() {
        return Flux.just(1,2,3,4)
            .delayElements(Duration.ofSeconds(1))
            .log();
    }

}



@RunWith(SpringRunner.class)
@WebFluxTest // This tell spring that we use annotation way in spring webflux, if we use functional way then just use normal @SpringBootTest + @AutoConfigureWebTestClient
public class FluxAndMonoControllerTetst {

    @Autowire
    WebTestClient WebTestClient;

    @Test 
    public void flux_approach1() {
        Flux<Integer> integerFlux = WebFluxTest.get().uri("/flux")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange() // trigger the controller 
            .expectStatus().isOk()
            .returnResult(Integer.class)
            .getResponseBody();

        StepVerifier.create(integerFlux)
        .expectSubscription()
        .expectNext(1)
        .expectNext(2)
        .expectNext(3)
        .expectNext(4)
        .verifyComplete();
    }
    
    @Test 
    public void flux_approach2() {
        WebFluxTest.get().uri("/flux")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()  // trigger the controller 
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
            .expectBodyList(Integer.class)  // convert value into List<Integer>
            .hasSize(4) // return body has 4 elements
    }

    @Test 
    public void flux_approach3() {
        List<Integer> expectedIntegerList = Arrays.asList(1, 2, 3, 4);

        EntityExchangeResult<List<Integer>> entityExchangeResult = WebFluxTest.get().uri("/flux")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()  // trigger the controller 
            .expectStatus().isOk()
            .expectBodyList(Integer.class) // convert value into List<Integer>
            .returnResult();

        assertEquals(expectedIntegerList, entityExchangeResult.getResponseBody());
    }

    @Test 
    public void flux_approach4() {
        List<Integer> expectedIntegerList = Arrays.asList(1, 2, 3, 4);

        EntityExchangeResult<List<Integer>> entityExchangeResult = WebFluxTest.get().uri("/flux")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()  // trigger the controller 
            .expectStatus().isOk()
            .expectBodyList(Integer.class) // convert value into List<Integer>
            .consumeWith((res) -> {
                assertEquals(expectedIntegerList, res.getResponseBody());
            })
    }
}

/**
 * Test Infinite Non Blocking Sequence API
 */

@RestController
public class FluxAndMonoController() {
    
    @GetMapping("/flux")
    public Flux<Integer> returnFlux() {
        return Flux.just(1,2,3,4)
            .delayElements(Duration.ofSeconds(1))
            .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE) // server side event push to http client, Server-Sent events as a much simpler alternative to WebSockets for doing push from the server to client.
    public Flux<Long> returnFluxStream() {
        return Flux.interval(Duration.ofSeconds(1))
            .log();
    }

}

@RunWith(SpringRunner.class)
@WebFluxTest
public class FluxAndMonoControllerTetst {

    @Autowire
    WebTestClient WebTestClient;

    @Test 
    public void fluxStream() {
        Flux<Long> longStreamFlux = WebFluxTest.get().uri("/fluxstream")
            .accept(MediaType.APPLICATION_STREAM_JSON_VALUE)
            .exchange() // trigger the controller 
            .expectStatus().isOk()
            .returnResult(Long.class)
            .getResponseBody();
        
        StepVerifier.create(longStreamFlux)
            .expectNext(0l)
            .expectNext(1l)
            .expectNext(2l)
            .thenCancel() // we can cancel infine stream
            .verify();
    }
}


/**
 * Test Mono
 */

@RestController
public class FluxAndMonoController() {
    
    @GetMapping("/mono")
    public Flux<Integer> returnFlux() {
        return Flux.just(1)
            .log();
    }

}

@RunWith(SpringRunner.class)
@WebFluxTest
public class FluxAndMonoControllerTetst {

    @Autowire
    WebTestClient WebTestClient;

    @Test 
    public void monoTest() {
        Integer expectedValue = new Integer(1);

        WebFluxTest.get().uri("/mono") // for single resource
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange() // connect to endpoin and trigger the controller 
            .expectStatus().isOk()
            .expectBody(Integer.class)
            .consumeWith((res) -> {
                assertEquals(expectedValue, res.getResponseBody());
            });
        
    }
}


