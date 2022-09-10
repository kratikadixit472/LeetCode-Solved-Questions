class StockPrice {

    PriorityQueue<int[]> minHeap, maxHeap;
    HashMap<Integer, Integer> timePriceMap;
    int latestTime ;
    public StockPrice() {
        minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        timePriceMap = new HashMap<>();
        latestTime = 0;
    }
    
    public void update(int timestamp, int price) {
        
        latestTime = Math.max(latestTime, timestamp);
        
        timePriceMap.put(timestamp, price);
        maxHeap.add(new int[]{price, timestamp});
        minHeap.add(new int[]{price, timestamp});
    }
    
    public int current() {
        return timePriceMap.get(latestTime);
    }
    
    public int maximum() {
        int[] top = maxHeap.peek();
        while(timePriceMap.get(top[1]) != maxHeap.peek()[0]){
            maxHeap.remove();
            top = maxHeap.peek();
        }
        return top[0];
    }
    
    public int minimum() {
        int[] top = minHeap.peek();
        while(timePriceMap.get(top[1]) != minHeap.peek()[0]){
            minHeap.remove();
            top = minHeap.peek();
        }
        return top[0];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */