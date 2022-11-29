class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map;
    List<Integer> al;
    Random rand;
    
    public RandomizedCollection() {
        map = new HashMap<>();
        al = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(al.size());
        al.add(val);
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0) return false;

        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        int lastEle = al.get(al.size()-1);
        al.set(loc, lastEle);

        map.get(lastEle).add(loc);
        map.get(lastEle).remove(al.size()-1);

        al.remove(al.size()-1);
        return true;
    }
    
    public int getRandom() {
        return al.get(rand.nextInt(al.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */