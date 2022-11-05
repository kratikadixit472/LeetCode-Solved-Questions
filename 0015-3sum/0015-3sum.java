class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            
            while(i != 0 && i < nums.length && nums[i-1] == nums[i]) i++;
            int l = i + 1, r = n - 1;
            while(l < r){
                
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0){
                    List<Integer> al = new ArrayList<>();
                    al.add(nums[i]); al.add(nums[r]); al.add(nums[l]);
                    l++; r--;
                    ans.add(al);
                    
                    while(l < r && nums[l-1] == nums[l]) l++;
                    while(l < r && nums[r+1] == nums[r]) r--;
                }
                else if(sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }
}