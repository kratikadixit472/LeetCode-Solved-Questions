class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] pop = new int[101];
        
        for(int[] l : logs){
            pop[l[0] - 1950]++;
            pop[l[1] - 1950]--;
        }
        
        int maxPop = 0, year = 0, sum = 0;
        
        for(int i = 0; i < 101; i++){
            sum += pop[i];
            if(maxPop < sum){
                maxPop = sum;
                year = 1950 + i;
            }
        }
        return year;
    }
}