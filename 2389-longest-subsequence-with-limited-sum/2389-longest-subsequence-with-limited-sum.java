class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        
        Arrays.sort(arr);
        int n = arr.length;
        
        int[] ans = new int[queries.length];
        int idx = 0;
        
        for(int sum : queries){
            
           int cnt = 0, curr = 0;
            
            for(int num : arr){
                curr += num;
                cnt++;
                
                if(curr == sum) break;
                else if(curr > sum){
                    curr = curr - num;
                    cnt--;
                }
            }
            
            ans[idx++] = cnt;
        }
        
        return ans;
    }
}