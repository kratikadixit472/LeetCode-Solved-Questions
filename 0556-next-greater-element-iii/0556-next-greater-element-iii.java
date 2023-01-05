class Solution {
    public int nextGreaterElement(int num) {
        
        char[] arr = ("" + num).toCharArray();
        
        int n = arr.length;
        int i = n-2;
        
        while(i >= 0 && arr[i + 1] <= arr[i]) i--;
        
        if(i < 0) return -1;
        
        int j = n-1;
        
        while(j >= 0 && arr[j] <= arr[i]) j--;
        
        swap(i, j, arr);
        reverse(i+1, arr);
        
        try {
            return Integer.parseInt(new String(arr));
        } catch (Exception e) {
            return -1;
        }
        
    }
    private void reverse(int i, char[] arr){
        
        int j = arr.length-1;
        while(i < j){
            swap(i, j, arr);
            i++; j--;
        }
    }
    private void swap(int i, int j, char[] arr){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}