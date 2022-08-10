class Solution {
    public int findMinDifference(List<String> timePoints) {
        
        Collections.sort(timePoints);
        
        String prevv = timePoints.get(0);
            
        String p1 = prevv.substring(0, 2);
        String p2 = prevv.substring(3, 5);
        
        int prev = Integer.valueOf(p1) * 60 + Integer.valueOf(p2);
        int first = prev, diff = Integer.MAX_VALUE;
        
        for(int i = 1; i < timePoints.size(); i++){
            String time = timePoints.get(i);
            
            String s1 = time.substring(0, 2);
            String s2 = time.substring(3, 5);
            
            int curr = Integer.valueOf(s1) * 60 + Integer.valueOf(s2);
            diff = Math.min(diff, curr - prev);
            
            prev = curr;
        }
        //System.out.println(prev +" "+ diff);
        return Math.min(diff, 1440 + first - prev);
    }
}