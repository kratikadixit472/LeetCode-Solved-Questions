class MyHashSet {
    
    final int MAX_LEN = 1000006;
    List<Integer>[] set;
    
    public MyHashSet() {
        set = new ArrayList[MAX_LEN];
    }
    
    private int getIndex(int key){
        return key % MAX_LEN;
    }
    
    private int getPosition(int index, int key){
        List<Integer> al = set[index];
        if(al == null) return -1;
        
        for(int i = 0 ; i < al.size(); i++){
            if(al.get(i) == key) return i;
        }
        return -1;
    }
    
    public void add(int key) {
        int index = getIndex(key);
        int pos = getPosition(index, key);
        
        if(pos < 0){
            if(set[index] == null){
                set[index] = new ArrayList<>();
            }
            set[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPosition(index, key);
        if(pos >= 0){
            set[index].remove(pos);
        }
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        int pos = getPosition(index, key);
        return pos >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */