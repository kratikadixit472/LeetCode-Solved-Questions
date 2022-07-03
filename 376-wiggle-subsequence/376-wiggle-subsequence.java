class Solution {
    public int wiggleMaxLength(int[] nums) {
        
        
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
        /*
        
        boolean isNegative = false, isPositive = false, isFirst = true;
        int max = 0;
        
        int[] dp = new int[nums.length];
        
        for(int i = 1 ; i < nums.length; i++){
            for(int j = 0; j < i ; j++){
                int diff = nums[i] - nums[j];
                
                if(!isFirst){
                    if(diff < 0){
                        isNegative = true;
                    }
                    else isPositive = true;
                }
                else if(isPositive && diff < 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    isNegative = true;
                    isPositive = false;
                }
                else if(isNegative && diff > 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    isNegative = false;
                    isPositive = true;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}*/