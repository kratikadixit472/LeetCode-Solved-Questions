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
        int l = 0, r = al.size()-1;
        while(l < r){
            int mid = l + (-l + r) / 2;
            Pair p = al.get(mid);
            if(p.t == time) return p.v;
            if(p.t < time){
                if(al.get(mid+1).t > time) return p.v;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return al.get(l).t > time ? "" : al.get(l).v;
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