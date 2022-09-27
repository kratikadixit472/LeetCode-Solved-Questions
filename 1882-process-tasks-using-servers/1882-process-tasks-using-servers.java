class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> serverq = new PriorityQueue<>((a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        PriorityQueue<int[]> taskq = new PriorityQueue<>((a, b) -> a[2] != b[2] ? a[2] - b[2] : (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        for(int i = 0; i < servers.length; i++){
            int server = servers[i];
            serverq.add(new int[]{server, i, 0});
        }
        
        int n = tasks.length;
        int[] ans = new int[n];
        
        for(int i = 0; i < n ; i++){
            
            while(!taskq.isEmpty() && taskq.peek()[2] <= i){
                
                serverq.offer(taskq.poll());

            }
            if(serverq.isEmpty()) {
                
                int[] curr = taskq.poll();
                ans[i] = curr[1];
                curr[2] += tasks[i];
                taskq.add(curr);
            }
            
            else {
                
                int nextSec = i + tasks[i];
                
                int[] freeServer = serverq.poll();
                ans[i] = freeServer[1];
                freeServer[2] = nextSec;
                
                taskq.add(freeServer);

            }
        }
        return ans;
    }
}