class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> w : wall){
            int cut = 0,  i = 0;
            for(int ele : w){
                if(i == w.size()-1) continue;
                cut += ele;
                map.put(cut, map.getOrDefault(cut, 0) + 1);
                i++;
            }
        }
        
        int maxCol = 0;
        for(int key : map.keySet()){
            maxCol = Math.max(maxCol, map.get(key)); 
        }
       
        return wall.size() - maxCol;
    }
}