class Solution {
    public long putMarbles(int[] weights, int k) {
        
        int n = weights.length;
        if(k == 1 || k == n) return 0;
        
        long ans = 0;
        
        List<Integer> al1 = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        
        for(int i = 0; i < n-1; i++){
            al1.add(weights[i] + weights[i+1]);
        }
        
        for(int i = 0; i < n-1; i++){
            al2.add(weights[i] + weights[i+1]);
        }
        
        Collections.sort(al1);
        
        for(int i = 0; i < k - 1 ;i++) {
            ans += al1.get(n-2-i) - al1.get(i);
        }
        
        return ans;
    }
}