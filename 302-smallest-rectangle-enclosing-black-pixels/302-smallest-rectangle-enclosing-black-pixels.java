class Solution {
    
    int top , left, right, bottom, n, m;
    
    public int minArea(char[][] image, int x, int y) {
        
        top = x; bottom = x;
        left = y; right = y;
        n = image.length; m = image[0].length;
        
        int[][] dir ={{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        
        DFS(x, y, image, dir);
        
        return (right - left) * (bottom - top);
    }
    
    private void DFS(int x, int y, char[][] image, int[][] dir){
        
        if(x >= 0 && y >= 0 && x < n && y < m && image[x][y] == '1'){
            image[x][y] = '0';

            top = Math.min(top, x);
            bottom = Math.max(bottom, x+1);
            left = Math.min(left, y);
            right = Math.max(right, y+1);
            DFS(x-1, y, image, dir);
            DFS(x+1, y, image, dir);    
            DFS(x, y-1, image, dir);
            DFS(x, y+1, image, dir);
        }
    }
}