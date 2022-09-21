class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans = new ArrayList<>();
        
        int l = 0, r = arr.length-1;
        
        while(r-l >= k){
            if(Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) r--;
            else l++;
        }
        for(int i = l; i <= r; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}