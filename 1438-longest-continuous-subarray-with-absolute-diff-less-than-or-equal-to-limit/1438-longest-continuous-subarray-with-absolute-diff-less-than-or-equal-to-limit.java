class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        
        int res = 1, left = 0;
        
        for(int right = 0; right < nums.length ; right ++){
            
            while(!maxD.isEmpty() && maxD.peekLast() < nums[right]){
                maxD.pollLast();
            }
            maxD.add(nums[right]);
            
            while(!minD.isEmpty() && minD.peekLast() > nums[right]){
                minD.pollLast();
            }
            minD.add(nums[right]);
            
            while(maxD.peekFirst() - minD.peekFirst() > limit){
                if(nums[left] == maxD.peekFirst()) maxD.pollFirst();
                if(nums[left] == minD.peekFirst()) minD.pollFirst();
                left++;
            }
            
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}