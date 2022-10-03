class Solution {
    
    private boolean isValid(String s){
        int cnt = 0;
        
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(') cnt++;
            else if(ch[i] == ')'){
                cnt--;
            }
            if(cnt < 0){
                return false;
            }
        }
        return (cnt == 0);
    }
    
    public List<String> removeInvalidParentheses(String s) {
        
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        // set.add(s);
        q.add(s);
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                String curr = q.poll();
                
                if(isValid(curr)){
                    ans.add(curr);
                }
                
                if(ans.isEmpty()){
                    for(int i = 0; i < curr.length(); i++){
                        if(curr.charAt(i) == '(' || curr.charAt(i) == ')'){
                            String ns = curr.substring(0, i) + curr.substring(i+1);
                            if(!set.contains(ns)){
                                set.add(ns);
                                q.offer(ns);
                            }
                        }
                    }
                }
            }
            if(!ans.isEmpty()) return ans;
        }
        // ans.add("");
        return ans;
    }
}