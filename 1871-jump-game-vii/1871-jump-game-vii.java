class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            
            while(!q.isEmpty() && q.peek()+maxJump < i) q.poll();
            
            if(q.isEmpty()) return false;
            
            int prev = q.peek();
            if(ch == '0' && prev+maxJump >= i && prev+minJump <= i){
                q.add(i);
                if(i == s.length() - 1) return true;
                
            }
        }
        return false;
    }
}