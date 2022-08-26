/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int l = 0;
        int r = 1;
        while(reader.get(r) < target){
            r = r * 2;
        }
        
        while(l <= r){
            
            int mid = (l + r) / 2;
            
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}