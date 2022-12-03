class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merge = new int[n + m];
        
        // if(n ==0 || m == 0){
            // return (n == 0) ? nums2[m] : nums1[n];
        // }
         
        int i=0, j=0, k=0;
        while(i < n && j<m){
            if(nums1[i]<nums2[j]){
                merge[k++] = nums1[i++];
            }
            else if(nums2[j] < nums1[i]){
                merge[k++] = nums2[j++];
            }
            else{
                merge[k++] = nums1[i++];
                merge[k++] = nums2[j++];
            }
        }
        while(i<n && k<merge.length){
            merge[k++] = nums1[i++];
        }
        while(j<m && k<merge.length){
            merge[k++] = nums2[j++];
        }
    
        
        if((n+m) % 2 != 0){
            int index = (n+m)/2;
            return merge[index] ;
        }
        
        int index = (n+m)/2;
        return (merge[index-1] + merge[index]) / 2.0 ;
            
    
    }
}