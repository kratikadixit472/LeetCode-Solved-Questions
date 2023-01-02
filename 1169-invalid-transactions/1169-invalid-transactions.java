class Solution {
    
    class Pair {
        
        Integer time, amount;
        String name, city;
        
        public Pair(String name, Integer time, Integer amount, String city){
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        
        Map<String, List<Pair>> map = new HashMap<>();
        int idx = 0;
        
        for(String t : transactions){
            String[] ts = t.split(",");
            
            Pair p = new Pair(ts[0],Integer.valueOf(ts[1]),Integer.valueOf(ts[2]),(ts[3]));
            map.putIfAbsent(p.name, new ArrayList<>());
            map.get(p.name).add(p);
        }
        
        for(String t : transactions){
            String[] ts = t.split(",");
            
            Pair p = new Pair(ts[0], Integer.valueOf(ts[1]),Integer.valueOf(ts[2]),(ts[3]));
            
            if(!isValid(p, map.getOrDefault(p.name, new ArrayList<>()))){
                ans.add(t);
            }
        }
        return ans;
    }
    
    private boolean isValid(Pair p, List<Pair> al){
        
        if(p.amount > 1000) return false;
        
        for(Pair pp : al){
            if(pp.name.equals(p.name) && !pp.city.equals(p.city) && Math.abs(pp.time - p.time) <= 60){
                return false;
            }
        }
        return true;
    }
}