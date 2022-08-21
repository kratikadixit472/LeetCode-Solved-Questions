class Solution {
    public int minSwaps(int[] nums) {
        
        int ones = 0, one = 0, left = 0;
        int max = Integer.MIN_VALUE, n = nums.length;
        
        for(int ele : nums) if(ele == 1) ones++;
        int right = 0;
        
        while(left < n){
            
            while(right - left < ones){
                one += nums[right++ % n];
            }
            //System.out.println(one+" "+right+" "+ right % n);
            max = Math.max(max, one);
            
            if(right % n == n || left == n) break;
            
            if(nums[left++] == 1) one--;
        }
        //System.out.println(max);
        return ones - max;
    }
}