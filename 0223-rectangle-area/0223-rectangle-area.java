class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        
        int horz = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int vert = Math.min(ay2, by2) - Math.max(ay1, by1);
        
        int overlapArea = 0;
        
        if(horz > 0 && vert > 0){
            overlapArea = horz * vert;
        }
        
        return areaA + areaB - overlapArea;
    }
}