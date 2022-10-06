class Solution {
    public String alphabetBoardPath(String t) {
        
        int prevR = 0, prevC = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < t.length(); i++){
            
            int r = (t.charAt(i) - 'a') / 5, c = (t.charAt(i) - 'a') % 5;
            
            
            getTargetPos(sb, prevR, prevC, r, c);
            sb.append('!');
            
            prevR = r; prevC = c;
        }
        return sb.toString();
    }
    
    private void getTargetPos(StringBuilder sb, int prex, int prey, int curx, int cury){
        
        while(prex > curx){
            sb.append('U');
            prex--;
        }
        while(prey < cury){
            sb.append('R');
            prey++;
        }
        while(prey > cury){
            sb.append('L');
            prey--;
        }
        while(prex < curx){
            sb.append('D');
            prex++;
        }
    }
}
