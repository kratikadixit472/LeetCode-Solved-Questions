class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int n = arr.length;
        Arrays.sort(arr);
        
        int diff = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int curr = arr[i] - arr[i-1];
            
            if(curr == diff){
                ans.add(Arrays.asList(arr[i-1], arr[i]));
            }
            else if(curr < diff){
                ans.clear();
                ans.add(Arrays.asList(arr[i-1], arr[i]));
                diff = curr;
            }
        }
        return ans;
    }
}