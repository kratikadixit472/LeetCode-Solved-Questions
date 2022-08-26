/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        
        int n = reader.length();
        int l = 0, r = n-1;
        
        while(l < r){
            
            int mid = (l + r) / 2;
            
            int val = 0;
            
            if((r - l) % 2 != 0) val = reader.compareSub(l, mid, mid+1, r);
            else if((r - l) % 2 == 0) val = reader.compareSub(l, mid, mid, r);
            
            if(val == 1) r = mid;
            else if(val == -1) l = mid + 1;
            else return mid;
        }
        return l;
    }
}