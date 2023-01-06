class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        
        for(String s : emails){
            StringBuilder sb = new StringBuilder();
            int flag = -1;
            char aRate = ' ';
            for(char c : s.toCharArray()){
                if(c == '@' && flag == 1) flag = 0;
                if(c == '.' && aRate != '@') continue;
                if((c == '+' && flag == -1) || flag == 1) {
                    flag = 1;
                    continue;
                }
                else{
                    sb.append(c);
                }
                if(c == '@') aRate = '@';
            }
            set.add(sb.toString());
        }
        for(String s : set){
            System.out.print(s+" ");
        }
        return set.size();
    }
}