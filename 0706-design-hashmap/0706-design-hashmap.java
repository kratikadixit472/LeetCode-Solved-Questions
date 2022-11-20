class MyHashMap {
    
    List<int[]> map;
    public MyHashMap() {
        map = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        boolean flag = true;
        for(int[] al : map){
            if(al[0] == key){
                al[1] = value;
                flag = false;
            }
        }
        if(flag){
            map.add(new int[]{key, value});
        }
    }
    
    public int get(int key) {
        int val = -1;
        for(int[] al : map){
            if(al[0] == key){
                val = al[1];
            }
        }
        return val;
    }
    
    public void remove(int key) {
        for(int i = 0; i < map.size(); i++){
            if(map.get(i)[0] == key){
                map.remove(i);
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */