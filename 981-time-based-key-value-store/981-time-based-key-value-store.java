class TimeMap {

    class Pair{
        String val;
        int time = 0;
        public Pair(String s, int time){
            this.val = s;
            this.time = time;
        }
    }
    
    Map<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    private String getValue(String key, List<Pair> al, int time){
        int ans = 0;
        String s = "";
        int l = 0, r = al.size()-1;
        
        while(l < r){
            int mid = l + (r - l) / 2;
            Pair p = al.get(mid);
            if(p.time == time) return p.val;
            if(p.time < time){
                if(al.get(mid+1).time > time) return p.val;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        return al.get(l).time > time ? "" : al.get(l).val;
    }
    public String get(String key, int timestamp) {
        
        List<Pair> al = map.get(key);
        String ans = "";
        if(al == null || al.size() < 0) return ans;
        
        return getValue(key, al, timestamp);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */