class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i <= rowIndex; i++){
            List<Integer> al = new ArrayList<>();
            
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) al.add(1);
                else{
                    al.add(ans.get(j) + ans.get(j-1));
                }
            }
            ans = al;
        }
        return ans;
    }
}