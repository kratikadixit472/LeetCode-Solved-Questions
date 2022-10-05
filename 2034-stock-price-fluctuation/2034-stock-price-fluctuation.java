class StockPrice {

    Map<Integer, Integer> map;
    PriorityQueue<int[]> maxP, minP;
    int current;
    
    public StockPrice() {
        map = new HashMap<>();
        maxP = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        minP = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        current = 0;
        
    }
    
    public void update(int timestamp, int price) {
        current = Math.max(current, timestamp);
      
        map.put(timestamp, price);
        maxP.add(new int[]{timestamp, price});
        minP.add(new int[]{timestamp, price});
        
    }
    
    public int current() {
        return map.get(current);
    }
    
    public int maximum() {
        while(!maxP.isEmpty() && map.get(maxP.peek()[0]) != maxP.peek()[1]) maxP.poll();
        return maxP.peek()[1];
    }
    
    public int minimum() {
        while(!minP.isEmpty() && map.get(minP.peek()[0]) != minP.peek()[1]) minP.poll();
        return minP.peek()[1];
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