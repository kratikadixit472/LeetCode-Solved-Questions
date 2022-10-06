class SnapshotArray {

    TreeMap<Integer, Integer>[] map;
    int snapID = 0;
    
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        for(int i = 0; i < length; i++){
            map[i] = new TreeMap<>();
            map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snapID, val);
    }
    
    public int snap() {
        return snapID++;
    }
    
    public int get(int index, int snap_id) {
        
        TreeMap<Integer, Integer> curr = map[index];
        Integer key = curr.floorKey(snap_id);
        return (key == null) ? 0 : curr.get(key);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
