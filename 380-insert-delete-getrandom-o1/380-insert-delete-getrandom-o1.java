class RandomizedSet {
    
    HashMap<Integer, Integer> map;
    List<Integer> al;
    Random rand;
    
    public RandomizedSet() {
        rand = new Random();
        map = new HashMap<>();
        al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, al.size());
        al.add(al.size(), val);
        return true;  
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int lastEle = al.get(al.size()-1);
        int idx = map.get(val);
        
        al.set(idx, lastEle);
        map.put(lastEle, idx);
        al.remove(al.size()-1);
        
        map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        return al.get(rand.nextInt(al.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */