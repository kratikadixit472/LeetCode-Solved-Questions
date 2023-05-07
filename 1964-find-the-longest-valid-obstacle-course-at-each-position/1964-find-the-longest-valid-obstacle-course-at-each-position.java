class Solution {
    public int binarySearch(int currNum, List<Integer> list) {
        
        int left = 0; 
        int right = list.size()-1;
        
        while(left < right) {
            int mid = (left+right)/2;
            
            if(list.get(mid) <= currNum) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        
        int n = obstacles.length;
        List<Integer> list = new ArrayList<>();
        list.add(obstacles[0]);
        
        int[] res = new int[obstacles.length];
        res[0] = 1;
        
        for(int i=1; i<n; i++) {
            
            int currNum = obstacles[i];
            
            if(currNum >= list.get(list.size()-1)) {
                list.add(currNum);
                res[i] = list.size();
            }
            
            else {   
                int idx = binarySearch(currNum, list);
                list.set(idx, currNum);
                res[i] = idx +1;
            }
        }
        
        return res;
    }
}