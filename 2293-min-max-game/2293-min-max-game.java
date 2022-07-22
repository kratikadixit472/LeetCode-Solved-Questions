class Solution {
    public int minMaxGame(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        List<Integer> al = new ArrayList<>();
        
        for(int ele : nums) al.add(ele);
        
        while(al.size() != 1){
            List<Integer> l = new ArrayList<>();
            boolean min = true, max = false;
            int nn = al.size();
            for(int i = 0; i < al.size(); i++){
                if(i % 2 ==0 && 2*i < nn && 2*i + 1 < nn){
                    
                    l.add(Math.min(al.get(2*i), al.get(2*i + 1)));
                        
                }
                else if(i % 2 != 0 && 2*i < nn && 2*i + 1 < nn){
                    
                    l.add(Math.max(al.get(2*i), al.get(2*i + 1)));
                 
                }
            }
            System.out.println();
            al = l;
        }
        return al.get(0);
    }
}