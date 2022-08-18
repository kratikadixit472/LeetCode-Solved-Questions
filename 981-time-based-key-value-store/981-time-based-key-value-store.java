class TimeMap {

    class Pair{
        String value;
        int timestamp;
        public Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    Map<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        //int time = 0;
        //String ans = "";
        
        // for(Pair p : map.get(key)){
        //     if(p.timestamp <= timestamp){
        //         time = p.timestamp;
        //         ans = p.value;
        //     }
        // }
        if(!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
       // return ans;
    }
    
    private String binarySearch(List<Pair> al, int timestamp){
        int l = 0, r = al.size()-1;
        
        while(l < r){
            int mid = (l + r) >> 1;
            if(al.get(mid).timestamp == timestamp) return al.get(mid).value;
            if(al.get(mid).timestamp < timestamp){
                if(al.get(mid + 1).timestamp > timestamp) return al.get(mid).value;
                l = mid + 1;
            }
            else r = mid - 1;
        }
        return (al.get(l).timestamp > timestamp) ? "" : al.get(l).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */