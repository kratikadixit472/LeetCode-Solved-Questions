class SnapshotArray {

    TreeMap<Integer, Integer>[] map;
    int snap = 0;
    
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        for(int i = 0; i < length; i++){
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snap, val);
    }
    
    public int snap() {
        snap++;
        return snap-1;
    }
   
    public int get(int index, int snap_id) {
        // while(snap_id >= 0 && !map[index].containsKey(snap_id)){
        //     snap_id--;
        //     if(snap_id == -1) return 0;
        // }
        return map[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 ["SnapshotArray","set","set","set","snap","get","snap"]
[[1],[0,4],[0,16],[0,13],[],[0,0],[]]
 */