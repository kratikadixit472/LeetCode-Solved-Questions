class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i-1 ; j > 0; j--){
                ans.set(j, ans.get(j) + ans.get(j-1));
            }
            ans.add(1);
        }
        return ans;
    }
}