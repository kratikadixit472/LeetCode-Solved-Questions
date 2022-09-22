class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map;
    List<Integer> al;
    java.util.Random rand = new java.util.Random();
    
    public RandomizedCollection() {
        map = new HashMap<Integer, Set<Integer>>();
        al = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) map.put(val, new LinkedHashSet<Integer>());
        
        map.get(val).add(al.size());
        al.add(al.size(), val);
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;
        
        int lastEle = al.get(al.size()-1);
        int idx = map.get(val).iterator().next();
        
        map.get(val).remove(idx);
        
        al.set(idx, lastEle); 
        map.get(lastEle).add(idx);
        
        map.get(lastEle).remove(al.size()-1);
        al.remove(al.size()-1);
        
        // map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return al.get(rand.nextInt(al.size()));
        // return 0;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */