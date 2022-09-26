class Solution {

    public int constrainedSubsetSum(int[] arr, int k) {
        
        int n = arr.length;
        
        int maxSum = arr[0];
        
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            
            int max = Math.max(0, dq.isEmpty() ? 0 : arr[dq.peekFirst()]);
            arr[i] = arr[i] + max;
            maxSum = Math.max(maxSum, arr[i]);
            
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.add(i);
            
            if(i - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }
        }
        return maxSum;
    }
}