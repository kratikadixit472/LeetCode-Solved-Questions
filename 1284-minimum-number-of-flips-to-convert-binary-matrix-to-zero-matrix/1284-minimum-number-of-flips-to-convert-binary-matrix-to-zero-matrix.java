class Solution {
    public int minFlips(int[][] mat) {
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        Set<String> vis = new HashSet<>();
        int n = mat.length, m = mat[0].length;
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < n*m; i++){
            res.append("0");
        }
        // String res = rs.toString();
        
        int minFlips = 0;
        
        String hash = getHash(mat);
        vis.add(hash);
        
        LinkedList<String> q = new LinkedList<>();
        q.add(hash);
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                String top = q.poll();
                
                if(top.equals(res.toString())) return minFlips;
               
                for(int i = 0; i < top.length(); i++){
                    int x = i / m,  y = i % m;
                    
                    Set<Integer> change = new HashSet<>();
                    change.add(i);
                    
                    for(int[] d : dir){
                        int r = x + d[0];
                        int c = y + d[1];
                        
                        if(r >= 0 && c >= 0 && r < n && c < m){
                            change.add(r*m + c);
                        }
                    }
                    
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < top.length(); j++){
                        char c = (!change.contains(j) ? top.charAt(j) : (top.charAt(j) == '1') ? '0' : '1');
                        sb.append(c);
                    }
                    if(vis.contains(sb.toString())) continue;
                    vis.add(sb.toString());
                    q.add(sb.toString());
                    
                }
            }
            minFlips++;
        }
        return -1;
    }
    
    private String getHash(int[][] mat){
        
        int n = mat.length, m = mat[0].length;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
}