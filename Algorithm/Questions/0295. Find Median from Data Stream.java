class MedianFinder {
    
    Queue<Integer> large = new PriorityQueue<>((a, b) -> a - b);
    Queue<Integer> small = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) { // logn
        // two conditions need to be hold
        // adding to small
        small.add(num);
        
        // 1) small.peek() < large.peek()
        if (!large.isEmpty() && !small.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        
        // 2) minHeap and maxHeap diff in 1 size
        if(small.size() > large.size() + 1){ 
            large.add(small.poll());
        } else if(large.size() > small.size() + 1){
            small.add(large.poll());
        }
    }
    
    public double findMedian() { O(1)
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.size() > large.size() ? small.peek() : large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */