class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new ArrayList<>();
        
        int start = -1, end = -1;
        
        for(int i=0; i<nums.length; i++){
            
            if(i + 1 < nums.length && nums[i]+1 == nums[i+1]){
                if(start == -1){
                    start = nums[i];
                }
            }
            else{
                end = nums[i];
                
                if(start == -1){
                    res.add(Integer.toString(end));
                }
                else{
                    String st = Integer.toString(start)+"->"+Integer.toString(end);
                    res.add(st);
                }
                start = -1;
                end = -1;
            }
        }
        
        return res;
        
    }
}