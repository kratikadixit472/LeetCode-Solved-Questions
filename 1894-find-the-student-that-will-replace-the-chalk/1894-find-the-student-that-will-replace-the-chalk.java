class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        
        int i = 0, n = chalk.length;
        while(true){
            if(i == n){
                i = 0;
            }
            if(chalk[i] > k) return i;
            else{
                k -= chalk[i];
                i++;
            }
        }
    }
}