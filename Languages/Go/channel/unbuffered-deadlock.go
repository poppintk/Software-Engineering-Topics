package main

func main() {
	c := make(chan bool)
	c <- true // blocked util some thread received message,  in this case will block forever, cuz no thread receive it
	<-c
}
