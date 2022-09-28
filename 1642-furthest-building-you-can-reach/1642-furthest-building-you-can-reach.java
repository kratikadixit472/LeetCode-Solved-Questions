class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        int n = heights.length, ans = -1;
        
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (r + l) / 2;
            if(check(heights, bricks, ladders, mid)){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean check(int[] heights, int bricks, int ladder, int mid){
        
        List<Integer> al = new ArrayList<>();
        
        for(int i = 1; i <= mid; i++){
            if(heights[i] < heights[i-1]) continue;
            int climb = heights[i] - heights[i-1];
            al.add(climb);
        }
        Collections.sort(al, Collections.reverseOrder());
        int needed = 0;
        
        for(int i = ladder; i < al.size(); i++){  
            needed += al.get(i);
            if(bricks < needed) return false;
        }
        return true;
    }
}