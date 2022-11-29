class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> al;
    Random rand;
    
    public RandomizedSet() {
        map = new HashMap<>();
        al = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, al.size());
        al.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc = map.get(val);
        if(loc < al.size()-1){
            int lastEle = al.get(al.size()-1);
            al.set(loc, lastEle);
            map.put(lastEle, loc);
        }
        map.remove(val);
        al.remove(al.size()-1);
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