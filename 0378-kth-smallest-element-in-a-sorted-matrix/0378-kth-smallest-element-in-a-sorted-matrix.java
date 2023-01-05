class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int n = matrix.length, m = matrix[0].length;
        
        for(int i = 0; i < n; i++){
            pq.add(new int[]{matrix[i][0], i, 0});
        }
        int[] top = new int[3];
        
        while(k-- > 0){
            top = pq.poll();
            
            int val = top[0], r = top[1], c = top[2];
            if(c + 1 < m){
                pq.add(new int[]{matrix[r][c+1], r, c + 1});
            }
        }
        return top[0];
    }
}