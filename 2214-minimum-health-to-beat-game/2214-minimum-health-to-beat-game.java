class Solution {
    public long minimumHealth(int[] damage, int armor) {
        
        long totalSum = 0, max = 0;
        for(int num : damage){
            totalSum += num;
            max = Math.max(max, num);
        }
        
        return totalSum - Math.min(max, armor) + 1;
    }
}