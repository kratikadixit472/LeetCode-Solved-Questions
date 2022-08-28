class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        int rounds = 0;
        
        for(int frq : map.values()){
            
            if(frq == 1) return -1;
            
            if(frq % 3 != 0){
                rounds += frq / 3 + 1;
            }
            else{
                rounds += frq / 3;
            }
        }
        return rounds;
    }
}