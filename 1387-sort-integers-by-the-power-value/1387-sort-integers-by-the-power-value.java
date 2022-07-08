class Solution {
    class Pair{
        int num, pow;
        public Pair(int num, int pow){
            this.num = num;
            this.pow = pow;
        }
    }
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {
        
        //int[][] pow = new int[hi - lo + 1][2];
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1]) ? b[0] - a[0] : b[1] - a[1]);
        // int idx = 0;
        
        map.put(1, 0);
        List<Pair> ans = new ArrayList<>();
        
        for(int i = lo; i <= hi; i++){
            getPower(i);
            ans.add(new Pair (i, map.getOrDefault(i, 0)));
            
            //if(pq.size() > k) pq.poll();
        }
        
        //Arrays.sort(pow, (a, b) -> (a[0] == b[0]) ? a[0] - b[0] : a[1] - b[1]);
        
        // for(int[] po : pow){
        //     System.out.print(po[0] +" "+ po[1] +", ");
        // } 
        
        ans.sort((a, b) -> (a.num == b.num) ? a.num - b.num : a.pow - b.pow);
        
        return ans.get(k-1).num;
        
    }
    
    private int getPower(int n){
        if(map.containsKey(n)) return map.get(n);
         
        int ans = (n % 2 == 0) ? getPower(n / 2)  :  getPower(3 * n + 1);
       
        map.put(n, ans + 1);
        return map.get(n);
    }
}