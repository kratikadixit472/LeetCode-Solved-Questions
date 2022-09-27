class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        
        for(int i = 0; i < n; i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroids[i]){
                    st.pop();
                }
                if(!st.isEmpty() && -asteroids[i] == st.peek()){
                    st.pop();
                } 
                else if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[st.size()];
        
        for(int i = st.size()-1; i>= 0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}