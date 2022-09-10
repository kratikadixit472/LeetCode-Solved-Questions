class StockPrice {

    TreeMap<Integer, Integer> frequencyMap;
    HashMap<Integer, Integer> timePriceMap;
    int latestTime ;
    public StockPrice() {
        frequencyMap = new TreeMap<>();
        timePriceMap = new HashMap<>();
        latestTime = 0;
    }
    
    public void update(int timestamp, int price) {
        
        latestTime = Math.max(latestTime, timestamp);
        
        if(timePriceMap.containsKey(timestamp)){
            int oldPrice = timePriceMap.get(timestamp);
            frequencyMap.put(oldPrice, frequencyMap.get(oldPrice)-1);
            
            if(frequencyMap.get(oldPrice) == 0){
                frequencyMap.remove(oldPrice);
            }
        }
        timePriceMap.put(timestamp, price);
        frequencyMap.put(price, frequencyMap.getOrDefault(price, 0) + 1);
        
    }
    
    public int current() {
        return timePriceMap.get(latestTime);
    }
    
    public int maximum() {
        return frequencyMap.lastKey();
    }
    
    public int minimum() {
        return frequencyMap.firstKey();
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