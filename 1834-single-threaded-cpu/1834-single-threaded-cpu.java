class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;
        int[][] sortedTime = new int[n][3];
        
        for(int i = 0; i < n; i++){
            sortedTime[i][0] = tasks[i][0];
            sortedTime[i][1] = tasks[i][1];
            sortedTime[i][2] = i;
        }
        
        int[] ansProcess = new int[n];
        Arrays.sort(sortedTime, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        
        int ansIdx = 0, taskIdx = 0;
        long currTime = 0;
        
        while(taskIdx < n || !pq.isEmpty()){
            
            if(pq.isEmpty() && currTime < sortedTime[taskIdx][0]){
                currTime = sortedTime[taskIdx][0];
            }
            
            while(taskIdx < n && currTime >= sortedTime[taskIdx][0]){
                pq.add(sortedTime[taskIdx]);
                ++taskIdx;
            }
            
            int processTime = pq.peek()[1];
            int index = pq.peek()[2];
            pq.remove();
            
            currTime += processTime;
            ansProcess[ansIdx++] = index;
        }
        return ansProcess;
    }
}