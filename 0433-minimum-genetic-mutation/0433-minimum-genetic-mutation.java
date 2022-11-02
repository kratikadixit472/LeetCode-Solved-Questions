class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        
        for(String s : bank) set.add(s);
        char[] gen = {'A', 'C', 'G', 'T'};
        
        LinkedList<String> q = new LinkedList<>();
        q.add(start);
        seen.add(start);
        int steps = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz-- > 0){
                
                String top = q.poll();

                if(top.equals(end)) return steps;
                
                char[] ch = top.toCharArray();
                
                for(int i = 0; i < top.length(); i++){
                    for(int k = 0 ; k < 4; k++){
                        ch[i] = gen[k];
                        String ngbr = new String(ch);
                        // System.out.println(s);
                        if(set.contains(ngbr) && !seen.contains(ngbr)){
                            seen.add(ngbr);
                            q.add(ngbr);
                        }
                        ch[i] = top.charAt(i);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}