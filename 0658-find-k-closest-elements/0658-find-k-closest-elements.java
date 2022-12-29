class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            pq.add(new int[]{Math.abs(arr[i] - x), arr[i]});
        }
        
        while(!pq.isEmpty() && k-- > 0){
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}