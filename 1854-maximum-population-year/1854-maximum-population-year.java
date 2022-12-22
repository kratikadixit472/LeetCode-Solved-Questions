class Solution {
    public int maximumPopulation(int[][] logs) {
        
        int[] pop = new int[101];
        
        for(int[] l : logs){
            for(int i = l[0]; i < l[1]; i++){
                pop[i - 1950]++;
            }
        }
        
        int maxPop = 0, year = 0;
        
        for(int i = 0; i < 101; i++){
            if(maxPop < pop[i]){
                maxPop = pop[i];
                year = 1950 + i;
            }
        }
        return year;
    }
}