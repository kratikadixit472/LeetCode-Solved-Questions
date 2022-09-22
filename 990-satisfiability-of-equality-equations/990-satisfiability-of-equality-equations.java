class Solution {
    public boolean equationsPossible(String[] equations) {
        
        
        List<Integer>[] graph = new ArrayList[26];
        
        for(int i = 0; i <26; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(String s : equations){
            char sign = s.charAt(1), a = s.charAt(0), b = s.charAt(3);
            if(sign == '='){
                graph[a-'a'].add(b-'a');
                graph[b-'a'].add(a-'a');
            }
        }
        
        int[] vis = new int[26];
        Arrays.fill(vis, -1);
        
        for(int i = 0; i < 26; i++){
            if(vis[i] == -1){
                DFS(i, i, vis, graph);
            }
        }
        
        for(String s : equations){
            char sign = s.charAt(1), a = s.charAt(0), b = s.charAt(3);
            if(sign == '!'){
                if(vis[a-'a'] == vis[b-'a']) return false;
            }
        }
        
        return true;
    }
    private void DFS(int i, int color, int[] vis, List<Integer>[] graph){
        
        if(vis[i] == -1){
            vis[i] = color;
            for(int j : graph[i]){
                DFS(j, color, vis, graph);
            }
        }
    }
}