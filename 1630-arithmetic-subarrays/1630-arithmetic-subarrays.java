class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        
        for(int i = 0; i < l.length; i++){
            boolean flag = true;
            int ij = 0;
            int[] tmp = new int[r[i] - l[i] + 1];
            
            for(int j = l[i]; j <= r[i]; j++){
                tmp[ij++] = nums[j];
            }
            Arrays.sort(tmp);
            
            for(int idx = 0; idx < tmp.length-1; idx++){
                
                if(tmp[idx + 1] - tmp[idx] != tmp[1] - tmp[0]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}