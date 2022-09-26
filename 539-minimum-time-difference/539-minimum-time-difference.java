class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        Collections.sort(timePoints);
        String s = timePoints.get(0);
        String p1 = s.substring(0, 2);
        String p2 = s.substring(3, 5);
        
        int prev = Integer.valueOf(p1) * 60 + Integer.valueOf(p2);
        int first = prev, diff = Integer.MAX_VALUE;
        
        for(int i = 1; i < timePoints.size(); i++){
            String curr = timePoints.get(i);
            
            String pp1 = curr.substring(0, 2);
            String pp2 = curr.substring(3, 5);
            
            int currVal = Integer.valueOf(pp1) * 60 + Integer.valueOf(pp2);
            
            diff = Math.min(diff, currVal - prev);
            
            prev = currVal;
        }
        
        return Math.min(diff, 1440 + first - prev);
    }
}