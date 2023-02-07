class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int i = 0, j = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(j = 0; j < n; j++){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2 && i < n){
                if(map.getOrDefault(fruits[i], 0) == 1){
                    map.remove(fruits[i]);
                }
                else{
                    map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}