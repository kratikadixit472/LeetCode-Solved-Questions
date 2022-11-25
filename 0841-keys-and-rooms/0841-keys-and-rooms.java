class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        
        while(!st.isEmpty()){
            int curr = st.pop();
            for(int ngbr : rooms.get(curr)){
                
                if(!seen[ngbr]){
                    seen[ngbr] = true;
                    st.add(ngbr);
                }
            }
        }
        for(boolean curr : seen){
            if(!curr) return false;
        }
        return true;
    }
}