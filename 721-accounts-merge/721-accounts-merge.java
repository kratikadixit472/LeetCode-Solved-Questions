class Solution {
    
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        par = new int[n];
        for(int i = 0; i <n; i++){ 
            par[i] = i;
        }
        
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> emailMap = new HashMap<>();
         
        for(int i = 0 ; i < n; i++){
            List<String> acc = accounts.get(i);
            
            for(int j = 1; j < acc.size(); j++){
                String email = acc.get(j);
                if(emailMap.containsKey(email)){
                    int oldIdx = emailMap.get(email);
                    union(i, oldIdx);
                }
                else{
                    emailMap.put(email, i);
                }
            }
            
        }
        
        Map<Integer, TreeSet<String>> nameIdToEmails = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int parent = findPar(i);
            nameIdToEmails.putIfAbsent(parent, new TreeSet<>());
            
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            
            nameIdToEmails.get(parent).addAll(emails);
        }
        
        for(int id : nameIdToEmails.keySet()){
            String name = accounts.get(id).get(0);
            List<String> emails = new ArrayList<>(nameIdToEmails.get(id));
            emails.add(0, name);
            ans.add(emails);
        }
        
        return ans;
    }
   
    
    private int findPar(int u){
        return (par[u] == u) ? u : (par[u] = findPar(par[u]));
    }
    private void union(int u, int v){
        int p1 = findPar(u), p2 = findPar(v);
        if(p1 != p2){
            par[p2] = par[p1];
        }
    }
}
