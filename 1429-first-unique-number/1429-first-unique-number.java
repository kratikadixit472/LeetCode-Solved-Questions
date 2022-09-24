class FirstUnique {

    Map<Integer, Boolean> map;
    Set<Integer> set ;
    
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        set = new LinkedHashSet<>();
        
        for(int ele : nums) this.add(ele);
    }
    
    public int showFirstUnique() {
        while(set.iterator().hasNext()){
            return set.iterator().next();
        }
        return -1;
    }
    
    public void add(int value) {
        if(!map.containsKey(value)){
            map.put(value, true);
            set.add(value);
        }
        else if(map.get(value)){
            map.put(value, false);
            set.remove(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */