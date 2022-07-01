class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        
        for(int i = 0; i < boxTypes.length; i++){
            int[] boxType = boxTypes[i];
            
            if(truckSize == 0) break;
            
            if(boxType[0] < truckSize){
                ans += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            }
            else if(boxType[0] >= truckSize){
                ans += (truckSize) * boxType[1];
                truckSize = 0;
            }
            //System.out.print(ans+" "+ truckSize+", ");
        }
        return ans;
    }
}