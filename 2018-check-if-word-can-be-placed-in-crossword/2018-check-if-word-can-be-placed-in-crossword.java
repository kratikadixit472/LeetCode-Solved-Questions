import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        Set<String> set = new HashSet<>();
        int n = board.length, m = board[0].length;
        
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < m; j++){
                if(board[i][j] == ' '){
                    sb.append('.');
                }
                else{
                    sb.append(board[i][j]);
                }
            }
            // System.out.print("first "+sb+" ");
            set.addAll(Arrays.asList(sb.toString().split("#")));
            set.addAll(Arrays.asList(sb.reverse().toString().split("#")));
        }
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < n; j++){
                if(board[j][i] == ' '){
                    sb.append('.');
                }
                else{
                    sb.append(board[j][i]);
                }
            }
            // System.out.print("sec "+sb+" ");
            set.addAll(Arrays.asList(sb.toString().split("#")));
            set.addAll(Arrays.asList(sb.reverse().toString().split("#")));
        }
        
        List<String> al = new ArrayList<>();
        
        for(String str : set){
            Pattern p = Pattern.compile(str);
			Matcher matcher = p.matcher(word);
			if(matcher.matches()){
				return true;
			}
        }
        return false;
    }
}