class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        int n = courses.length;
        int count = 0, time = 0;
        
        for(int i = 0; i < n ; i++){
            if(time + courses[i][0] <= courses[i][1]){
                time += courses[i][0];
                count++;
            }
            
            else{
                int max_i = i;
                for(int j = 0; j < i; j++){
                    if(courses[j][0] > courses[max_i][0]){
                        max_i = j;
                    }
                }
                if(courses[i][0] < courses[max_i][0]){
                    time += courses[i][0] - courses[max_i][0];
                }
                courses[max_i][0] = -1;
            }
        }
        return count;
    }
}