class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        Map<Integer, PriorityQueue<Integer>> sortDiagonal = new HashMap<>();
        int n = mat.length, m = mat[0].length;
        
        for(int row = 0;  row < n; row++){
            for(int col = 0; col < m; col++){
                sortDiagonal.putIfAbsent(row - col, new PriorityQueue<>());
                sortDiagonal.get(row - col).add(mat[row][col]);
            }
        }
        
        for(int row = 0;  row < n; row++){
            for(int col = 0; col < m; col++){
                mat[row][col] = sortDiagonal.get(row-col).poll();
            }
        }
        return mat;
    }
}