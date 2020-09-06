class KthLargest {
    
    // a priority queue is by default a min heap
    PriorityQueue<Integer> minHeap;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        
        this.k = k; 
        minHeap = new PriorityQueue<>();
        
        for(int n : nums){
            add(n);
        }
        
    }
    
    public int add(int val) {
        
        //Will store elements in ascending order
        minHeap.add(val);
        
        //We only save k elements at a time
        if(minHeap.size() > k)
            minHeap.poll();
        
        //The first element will be the kth largest element
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
