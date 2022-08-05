class Solution {
    
    private void DFS(int i, int[] arr, int []edges, int dist){
        
        while(i != -1 && arr[i] == -1){
            arr[i] = dist++;
            i = edges[i];
        }
    }
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        
        DFS(node1, arr1, edges, 0);
        DFS(node2, arr2, edges, 0);
        
        int minDis = Integer.MAX_VALUE, res = -1;
        
        for(int i = 0; i < n; i++){
            if(Math.min(arr1[i], arr2[i]) >= 0 && Math.max(arr1[i], arr2[i]) < minDis){
                minDis = Math.max(arr1[i], arr2[i]);
                res = i;
            }
        }
        return res;
    }
}