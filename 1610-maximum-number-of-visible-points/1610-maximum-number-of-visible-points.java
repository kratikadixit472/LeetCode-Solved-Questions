class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        
        List<Double> angles = new ArrayList<>();
        int same = 0;
        
        for(List<Integer> p : points){
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            
            if(dx == 0 && dy == 0){
                same++;
                continue;
            }
            double angl = Math.toDegrees(Math.atan2(dy, dx));
            angles.add(angl);
        }
        Collections.sort(angles);
        
        for(int i = 0; i < angles.size(); i++){
            if(angles.get(i) < 0){
                angles.add(angles.get(i) + 360);
            }
        }
        
        int ans = 0;
        
        for(int i = 0, j = 0; j < angles.size(); j++){
            while(angles.get(j) - angles.get(i) > angle){
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans + same;
    }
}