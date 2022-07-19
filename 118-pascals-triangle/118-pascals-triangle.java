class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++){
            List<Integer> al = new ArrayList<>();
            for(int j = 0; j <=i; j++){
                
                if(j == 0 || j == i)  al.add(1);
                
                else{
                    al.add(prev.get(j-1) + prev.get(j));
                }
                
            }
            ans.add(al);
            prev = al;
        }
        
        return ans;
    }
}