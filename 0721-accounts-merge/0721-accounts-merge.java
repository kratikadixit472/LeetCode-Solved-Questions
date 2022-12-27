class Solution {
    Map<String, List<String>> adj = new HashMap<>();
    Set<String> vis = new HashSet<>();
    
    private void DFS(String email, List<String> al){
        al.add(email);
        vis.add(email);
        
        if(adj.get(email) == null) return;
        
        for(String ngbr : adj.get(email)){
            if(!vis.contains(ngbr)){
                DFS(ngbr, al);
            }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> ans = new ArrayList<>();
        
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            for(int i = 2; i < account.size(); i++){
                String email = account.get(i);
                
                if(!adj.containsKey(firstEmail)){
                    adj.put(firstEmail, new ArrayList<>());
                }
                adj.get(firstEmail).add(email);
                
                if(!adj.containsKey(email)){
                    adj.put(email, new ArrayList<>());
                }
                adj.get(email).add(firstEmail);
            }
        }
        
        for(List<String> account : accounts){
            String name = account.get(0);
            String firstEmail = account.get(1);
            
            List<String> merge = new ArrayList<>();
            
            if(!vis.contains(firstEmail)){
                merge.add(name);
                DFS(firstEmail, merge);
                Collections.sort(merge.subList(1, merge.size()));
                ans.add(merge);
            }
        }
        return ans;
    }
}
/*[["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]*/