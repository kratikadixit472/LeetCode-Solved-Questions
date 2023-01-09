class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int ele : nums){
            if(!set.contains(ele-1)){
                int cnt = 0;
                while(set.contains(ele)){
                    cnt++;
                    ele++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}