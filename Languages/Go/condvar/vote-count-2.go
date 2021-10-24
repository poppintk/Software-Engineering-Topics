package main

import "sync"
import "time"
import "math/rand"

func main() {
	rand.Seed(time.Now().UnixNano())

	count := 0
	finished := 0
	var mu sync.Mutex

	for i := 0; i < 10; i++ {
		go func() {
			vote := requestVote()
			mu.Lock()
			defer mu.Unlock()
			if vote {
				count++
			}
			finished++
		}()
	}

	for {
		//NOTE:
		// Alrough, this imlementation is correct, but this while loop will be buzy waiting, in this main thread will burning 100% of cpu on runing while true.
		mu.Lock()

		if count >= 5 || finished == 10 {
			break
		}
		mu.Unlock()
		// time.Sleep(50*time.Millisecond) , help to solve, but still not perfect
	}
	if count >= 5 {
		println("received 5+ votes!")
	} else {
		println("lost")
	}
	mu.Unlock()
}

func requestVote() bool {
	time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
	return rand.Int() % 2 == 0
}
