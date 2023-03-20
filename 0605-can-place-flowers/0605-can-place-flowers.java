class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int N) {
        
        int n = flowerbed.length, count = 0;
        
        for(int i = 0; i < n; i++){
            
            if(flowerbed[i] == 0){

                boolean left = (i == 0) || (flowerbed[i-1] == 0);
                boolean right = (i == n-1) || (flowerbed[i+1] == 0);

                if(left && right){
                    count++;
                    flowerbed[i] = 1;
                }
            }
        }
        
        return (count >= N);
    }
}