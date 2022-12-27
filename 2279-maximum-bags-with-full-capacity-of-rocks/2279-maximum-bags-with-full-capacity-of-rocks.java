class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        List<Integer> al = new ArrayList<>();
        int ans = 0, n = capacity.length;
        
        for(int i = 0; i < n; i++){
            int diff = capacity[i] - rocks[i];
            if(diff != 0){
                al.add(diff);
            }else{
                ans++;
            }
        }
        Collections.sort(al);
        
        for(int i = 0; i < al.size(); i++){
            int curr = al.get(i);
            additionalRocks = additionalRocks - curr;
            if(additionalRocks < 0) break;
            ans++;
        }
        return ans;
    }
}