class KthLargest {
    private PriorityQueue <Integer> minheap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k =k;
        this.minheap = new PriorityQueue<>();
        for (int x: nums){
            add(x);
        }
    }
    
    public int add(int val) {
        minheap.offer(val);
        if (minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */