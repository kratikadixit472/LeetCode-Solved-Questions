class Solution {
    
    class Pair{
        int w, id;
        int nextSec;
        
        public Pair(int id, int w){
            this.id = id;
            this.w = w;
        }
    }
    
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> freeServer = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? (a[0] - b[0]) : (a[1] - b[1]));
        
        PriorityQueue<int[]> filledServer = new PriorityQueue<>((a, b) -> (a[2] != b[2]) ? (a[2] - b[2]) : ((a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0])));
        
        
        for(int i = 0; i < servers.length; i++){
            freeServer.add(new int[]{servers[i], i, 0});
        }
        
        int[] ans = new int[tasks.length];
        
        for(int i = 0;  i < tasks.length; i++){
            
            int task = tasks[i];
            
            while(!filledServer.isEmpty() && filledServer.peek()[2] <= i){
               
                freeServer.add(filledServer.poll());
            }
            
            if(freeServer.isEmpty()){
                
                int[] curr = filledServer.poll();
                ans[i] = curr[1];
                curr[2] += task;
                filledServer.add(curr);
                
            }
             else{
                 
                int nextSec = i + task;
                
                int[] curr = freeServer.poll();
                ans[i] = curr[1];
                curr[2] = nextSec;
                
                filledServer.add(curr);
                
            }
        }
        return ans;
    }
}