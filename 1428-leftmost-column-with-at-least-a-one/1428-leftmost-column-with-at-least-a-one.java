/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        
        int smallest = cols;
        
        for(int i = 0; i < rows; i++){
            
            int l = 0, r = cols-1;
            
            while(l < r){
                int mid = (l + r) / 2;
            
                if(binaryMatrix.get(i, mid) == 1){
                      r = mid;
                }
                else l = mid + 1;
            }
            if(binaryMatrix.get(i, l) == 1) smallest = Math.min(smallest, l);
        }
        return smallest == cols ? -1 : smallest;
    }
}