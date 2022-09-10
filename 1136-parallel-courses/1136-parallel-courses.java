class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[n+1];
        
        for(int[] rel : relations){
            graph[rel[1]].add(rel[0]);
            indegree[rel[0]]++;
        }
        LinkedList<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0) {
                q.add(i);
            // System.out.print(indegree[i]+ " "+i+", ");
            }
        }
        
        int semeters = 0, courseCount = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            semeters++;
            while(sz-- > 0){
                int top = q.poll();
                courseCount++;
                for(int next : graph[top]){
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        return courseCount != n ? -1 : semeters;
    }
}