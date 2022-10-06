class Solution {
    public String boldWords(String[] words, String s) {
        
        int boldTill = -1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            for(String w : words){
                
                if(s.startsWith(w, i)){
                    if(i > boldTill) sb.append("<b>");
                    boldTill = Math.max(boldTill, i + w.length());
                }
            }
            if(i == boldTill) sb.append("</b>");
            sb.append(s.charAt(i));
        }
        if(s.length() == boldTill) sb.append("</b>");
        return sb.toString();
    }
}