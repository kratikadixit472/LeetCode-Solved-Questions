class Solution {
    public int[] exclusiveTime(int n, List<String> logs)
    {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        int prev = 0;
        
        for(int i = 0; i < logs.size(); i++){
            String[] arr = logs.get(i).split(":");
            
            if(arr[1].equals("start")){
                if(!st.isEmpty()) { res[st.peek()] += Integer.valueOf(arr[2]) - prev; }
                prev = Integer.valueOf(arr[2]);
                st.push(Integer.valueOf(arr[0]));
            }
            else{
                res[st.pop()] += Integer.valueOf(arr[2]) - prev + 1;
                prev = Integer.valueOf(arr[2]) + 1;
            }
        }
        return res;
    }
}