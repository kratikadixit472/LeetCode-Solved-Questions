class Vector2D {

    int i = 0, j = 0;
    int[][] mat;
    
    public Vector2D(int[][] vec) {
        mat = vec;
    }
    
    public int next() {
        if(hasNext()) return mat[i][j++];
        return -1;
    }
    
    public boolean hasNext() {
        
        while(i < mat.length && j == mat[i].length){
            i++;
            j = 0;
        }
        return i < mat.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */