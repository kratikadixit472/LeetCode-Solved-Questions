class Solution {
    
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        DFS(sr, sc, color, image, image[sr][sc]);
        
        
        return image;
    }
    
    private void DFS(int sr, int sc, int color, int[][] image, int found){
        
        //boolean result = true;
        image[sr][sc] = color;
        for(int[] d : dir){
            int r = sr + d[0];
            int c = sc + d[1];
            
            if(r >= 0 && c >= 0 && r < image.length && c < image[0].length && found == image[r][c] && image[r][c] != image[sr][sc]){
                //System.out.println(found);
                DFS(r, c, color, image, found) ;
            }
        }
    }
}

// [[1,1,1],
//  [1,1,2],
//  [1,0,1]]
 
// [[2,2,2],
//  [2,2,0],
//  [2,0,1]]