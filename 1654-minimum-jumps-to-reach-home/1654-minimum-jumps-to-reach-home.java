class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        Set<String> set = new HashSet<>();
        Set<Integer> vis = new HashSet<>();
        int further = x + a + b;
        
        for(int forbid : forbidden){
            further = Math.max(further, a + forbid + b);
            set.add(forbid+" "+1);
            set.add(forbid+" "+0);
        }
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 1});
        
        //int start = 0, ans = 0, back = 0;
        int ans = 0;
        
        while(!q.isEmpty()){
            int sz = q.size();
            while(sz-- > 0){
                
                int[] top = q.poll();
                int start = top[0], pos = top[1];
                String s = new String(start+" "+pos);
                
                if(!set.contains(s)){
                set.add(s);
                
                if(start == x) return ans;

                if(start + a <= further  && !set.contains(start + a)){
                    q.add(new int[]{start + a, 1});
                }
                if(pos == 1 && start - b >= 0 && !set.contains(start - b)){
                    q.add(new int[]{start - b, 0});
                }
                }
            }
            ans++;
        }
        
        return -1;
    }
}