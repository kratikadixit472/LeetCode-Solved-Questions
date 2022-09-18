class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0) continue;
            q.add(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        
        while(!q.isEmpty()){
            int top = q.poll();
            res[idx++] = top;
            for(int ngbr : graph[top]){
                indegree[ngbr]--;
                if(indegree[ngbr] == 0) q.add(ngbr);
            }
        }
        if(numCourses > 0 && idx != numCourses) return new int[0];
        return res;
    }
}