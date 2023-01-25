class Solution {
    public int countPairs(int[] deliciousness) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        int mod = (int)(1e9 + 7);
        
        for(int ele : deliciousness){
            int pow = 1;
            
            for(int i = 0; i < 22; i++){
                if(map.containsKey(pow - ele)){
                    ans += map.get(pow - ele);
                    ans %= mod;
                }
                pow = pow * 2;
            }
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return ans;
    }
}