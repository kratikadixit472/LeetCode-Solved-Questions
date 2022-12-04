class HitCounter {

    TreeMap<Integer, Integer> map;
    
    public HitCounter() {
        map = new TreeMap<>();
    }
    
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    }
    
    public int getHits(int timestamp) {
        int hit = 0;
        int exact = timestamp - 300;
        for(int key : map.keySet()){
            if(key > exact && key <= timestamp){
                hit += map.get(key);
            }
        }
        return hit;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */