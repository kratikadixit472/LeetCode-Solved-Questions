class Solution {
    public int minArea(char[][] image, int x, int y) {
        
        int top = x, bottom = x;
        int left = y, right = y;
        
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] == '1') {
                    // System.out.println(top+" "+ bottom+" "+ left +" "+right);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i+1);
                    left = Math.min(left, j);
                    right = Math.max(right, j+1);
                }
            }
        }
        
        return (right - left) * (bottom - top);
    }
}