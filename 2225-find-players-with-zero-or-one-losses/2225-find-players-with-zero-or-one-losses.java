class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        List<Integer> wal = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int[] m : matches){
            if(!map.containsKey(m[0])) set.add(m[0]);
            map.put(m[1], map.getOrDefault(m[1], 0) + 1);
        }
        
        List<Integer> dal = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == 1) dal.add(key);
        }
        for(int ele : set){
            if(!map.containsKey(ele)) wal.add(ele);
        }
        Collections.sort(wal);
        Collections.sort(dal);
        
        ans.add(wal);
        ans.add(dal);
        return ans;
    }
}