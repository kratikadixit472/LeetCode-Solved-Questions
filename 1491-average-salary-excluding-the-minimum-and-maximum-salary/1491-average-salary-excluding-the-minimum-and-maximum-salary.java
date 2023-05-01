class Solution {
    public double average(int[] salary) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        int n = salary.length;
        
        for(int sal : salary){
            sum += sal;
            
            min = Math.min(min, sal);
            max = Math.max(max, sal);
        }
        
        return (double)(sum - min - max) / (n - 2);
    }
}