class TimeMap {

    class Pair{
        int t;
        String v;
        public Pair(String val, int time){
            this.v = val;
            this.t = time;
        }
    }
    
    Map<String, List<Pair>> map ;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    private String getValue(int time, List<Pair> al){
        int l = 0, r = al.size();
        while(l < r){
            int mid = (l + r) / 2;
            Pair p = al.get(mid);
            
            if(p.t <= time){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        return (r == 0) ? "" : al.get(r-1).v;
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null) return "";
        String val = getValue(timestamp, map.get(key));
        return val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */