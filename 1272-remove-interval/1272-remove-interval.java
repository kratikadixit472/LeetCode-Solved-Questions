class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int x = toBeRemoved[0], y = toBeRemoved[1];
        
        boolean flag = false;
        for(int[] interval : intervals){
            int a = interval[0], b = interval[1];
            
            if(a > y || b < x){
                ans.add(Arrays.asList(a, b));
            }
            else{
                if(a < x){
                    ans.add(Arrays.asList(a, x));
                }
                if(b > y){
                    ans.add(Arrays.asList(y, b));
                }
            }
        }
        return ans;
    }
}