package main

import "sync"
import "time"
import "fmt"




//
when lock on shared state, make sure that property is still true in this case total := alice + bob
we call this invariant, lock need to protect invariant being broken.

func main() {
	alice := 10000
	bob := 10000
	var mu sync.Mutex

	total := alice + bob

	go func() {
		for i := 0; i < 1000; i++ {
			mu.Lock()
			alice -= 1
			mu.Unlock()
			mu.Lock()
			bob += 1
			mu.Unlock()
		}
	}()
	go func() {
		for i := 0; i < 1000; i++ {
			mu.Lock()
			bob -= 1
			mu.Unlock()
			mu.Lock()
			alice += 1
			mu.Unlock()
		}
	}()

	start := time.Now()
	for time.Since(start) < 1*time.Second {
		mu.Lock()
		if alice+bob != total {
			fmt.Printf("observed violation, alice = %v, bob = %v, sum = %v\n", alice, bob, alice+bob)
		}
		mu.Unlock()
	}
}
