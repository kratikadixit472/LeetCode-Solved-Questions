class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> ans = new ArrayList<>();
        int n = words.length, index = 0; 
        
        while(index < words.length){
            
            int count = words[index].length();
            int last = index + 1;
            
            while(last < n){
                if(count + 1 + words[last].length() <= maxWidth){
                    count +=  1 + words[last].length();
                    last++;
                }
                else break;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;
            
            if(last == n || diff == 0){
                
                for(int i = index + 1; i < last; i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i = sb.length(); i < maxWidth; i++){
                    sb.append(" ");
                }
            }
            
            else{
                
                int spaces = (maxWidth - count) / diff;
                int odd = (maxWidth - count) % diff;
                
                for(int i = index + 1; i < last; i++){
                    for(int k = spaces; k > 0 ; k--){
                        sb.append(" ");
                    }
                    if(odd > 0){
                        sb.append(" ");
                        odd--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            ans.add(sb.toString());
            index = last;
        }
        return ans;
    }
}