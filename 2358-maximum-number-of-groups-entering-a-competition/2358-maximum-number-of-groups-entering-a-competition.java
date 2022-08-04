class Solution {
    public int maximumGroups(int[] grades) {
        
        Arrays.sort(grades);
        
        int currCount = 0, prevCount = 0;
        int currSum = 0, prevSum = 0, res = 0;
        
        for(int ele : grades){
            
            currSum += ele;
            currCount++;
            
            if(currCount > prevCount && currSum > prevSum){
                prevSum = currSum;
                prevCount = currCount;
                currSum = currCount = 0;
                res++;
            }
        }
        return res;
    }
}