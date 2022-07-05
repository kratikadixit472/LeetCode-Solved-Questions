class Solution {
    
    int lastI = 0, lastJ = 0;
    
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        int count = 0;
        
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<m; j++){
                lastI = 0; lastJ = 0;
                if(land[i][j] == 1){
                    List<Integer> al = new ArrayList<>();
                    dfs(i, j, n, m, land, dir);
                    al.add(i); al.add(j);
                    al.add(lastI); al.add(lastJ);
                    res.add(al);
                }
            }
        }
        
        int[][] ans = new int[res.size()][4];
        
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < 4; j++){
                //System.out.println(res.get(i).get(j));
                ans[i][j] = res.get(i).get(j);
            }
        }
        
        return ans;
    }
    
    private void dfs(int i, int j, int n, int m, int[][] land, int[][] dir){
        
        land[i][j] = 0;
        
        lastI = Math.max(lastI, i); lastJ = Math.max(lastJ, j);
        
        for(int d = 0 ; d < 4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            
            if(r < 0 || c < 0 || r >= n || c >= m || land[r][c] == 0) continue;
            
            dfs(r, c, n, m, land, dir);
        }
    }
}