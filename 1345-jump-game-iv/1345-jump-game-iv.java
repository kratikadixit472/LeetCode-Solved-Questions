class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n<=1){
            return 0;
        }
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i=0; i<n; i++){
            hm.computeIfAbsent(arr[i], v->new LinkedList<>()).add(i);
        }
        List<Integer> cur = new LinkedList<>();
        cur.add(0);
        Set<Integer> vis = new HashSet<>();
        int step = 0;

        while(!cur.isEmpty()){
            List<Integer> p = new LinkedList<>();
            for(int node:cur){
                if(node==n-1){
                    return step;
                }
 
                for(int child:hm.get(arr[node])){
                    if(!vis.contains(child)){
                        vis.add(child);
                        p.add(child);
                    }
                }
                hm.get(arr[node]).clear();

                if(node+1<n && !vis.contains(node+1)){
                    vis.add(node+1);
                    p.add(node+1);
                }
                if(node-1>=0 && !vis.contains(node-1)){
                    vis.add(node-1);
                    p.add(node-1);
                }
            }
            cur = p;
            step++;
        }
        return step;
    }
}