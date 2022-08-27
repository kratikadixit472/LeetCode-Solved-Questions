class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> ans = new ArrayList<>();
        
        if(finalSum % 2 != 0) return ans;
        
        long currSum = 0;
        long i = 2;
        
        while(currSum + i <= finalSum){
            currSum += i;
            ans.add(i);
            i += 2;
        }
        
        if(currSum < finalSum){
            long lastEle = ans.get(ans.size()-1);
            ans.remove(ans.size()-1);
            
            long rem = finalSum - currSum;
            ans.add(lastEle + rem);
        }
            
        return ans;
    }
}