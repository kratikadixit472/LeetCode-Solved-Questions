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
        
        int row = 0, col = cols - 1;
        
        while(row < rows && col >= 0){
            
            if(binaryMatrix.get(row, col) == 1) col--;
            else row++;
        }
        return (col == cols - 1) ?  -1 : col + 1;
    }
}