class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length, m = image[0].length;
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        int same = image[sr][sc];
        DFS(sr, sc, n, m, image, color, dir, same);
       
        return image;
    }
    
    private void DFS(int sr, int sc, int er, int ec, int[][] image, int color, int[][] dir, int same){
        
        image[sr][sc] = color;
        
        for(int[] d : dir){
            
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r >= 0 && c >= 0 && r<er && c<ec && image[r][c] == same && image[r][c] != color){
                DFS(r, c, er, ec, image, color, dir, same);
            }
        }
    }
}