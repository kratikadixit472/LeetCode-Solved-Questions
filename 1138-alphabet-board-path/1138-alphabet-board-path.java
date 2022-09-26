class Solution {
    public String alphabetBoardPath(String target) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        
        for(char C : target.toCharArray()){
            
            int r = (C - 'a') / 5, c = (C - 'a') % 5;
            
            if(i == r && j == c){
                sb.append("!");
            }
            else{
                getPath(sb, i, j, r, c);
                sb.append("!");
                i = r; j = c; 
            }
            
        }
        return sb.toString();
    }
    
    private void getPath(StringBuilder sb, int i, int j, int r, int c){
        
        while(i > r){
            sb.append("U");
            r++;
        }
        while(j < c){
            sb.append("R");
            c--;
        }
        while(j > c){
            sb.append("L");
            c++;
        }
        while(i < r){
            sb.append("D");
            r--;
        }
        
    }
}