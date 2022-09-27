class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        
        List<Long> al = new ArrayList<>();
        
        if(finalSum % 2 != 0) return al;
        
        long currSum = 0 , i = 2;
        
        while(currSum + i <= finalSum){
            currSum += i;
            al.add(i);
            i += 2;
        }
        if(finalSum - currSum == 0) return al;
        
        long last = al.get(al.size() - 1);
        al.remove(al.size() - 1) ;
        al.add(last + finalSum - currSum);
        return al;
    }
}