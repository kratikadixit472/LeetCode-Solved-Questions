class Solution {
    public int getKth(int lo, int hi, int k) {
        
        //int[][] pow = new int[hi - lo + 1][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]);
        int idx = 0;
        
        for(int i = lo; i <= hi; i++){
            pq.add(new int[] {i, getPower(i)});
            if(pq.size() > k) pq.poll();
        }
        
        //Arrays.sort(pow, (a, b) -> (a[0] == b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        // for(int[] po : pow){
        //     System.out.print(po[0] +" "+ po[1] +", ");
        // }
        int[] ans = pq.peek();
        return ans[0];
        
    }
    
    private int getPower(int n){
        if(n == 1) return 0;
        
        int ans = 0;
        if(n % 2 == 0) ans += getPower(n / 2) + 1;
        else{
            ans += getPower(3 * n + 1) + 1;
        }
        return ans;
    }
}