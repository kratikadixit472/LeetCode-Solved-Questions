class Solution {
    
    class Pair {
        
        int val;
        char s;     
        public Pair(int val, char s){
            this.val = val;
            this.s = s;
        }
    }
    
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            pq.add(new Pair(e.getValue(), e.getKey()));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            while(p.val-- > 0){
                sb.append(p.s);
            }
        }
        return sb.toString();
    }
}