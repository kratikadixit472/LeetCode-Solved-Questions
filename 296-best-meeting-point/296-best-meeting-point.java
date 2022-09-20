class Solution {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0) continue;
                rows.add(i);
                cols.add(j);
            }
        }
        
        int row = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col = cols.get(cols.size() / 2);
        
        return getMinDistance(rows, row) + getMinDistance(cols, col);
    }
    
    private int getMinDistance(List<Integer> al, int point){
        int distance = 0;
        for(int ele : al){
            distance += Math.abs(point - ele);
        }
        return distance;
    }
}