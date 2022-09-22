class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = reverse(arr[i]);
        }
        String ss = String.join(" ", arr);
        return ss;
    }
    private String reverse(String s){
        
        char[] ch = s.toCharArray();
        int l = 0, r = s.length()-1;
        while(l < r){
            char c = ch[l];
            ch[l] = ch[r];
            ch[r] = c;
            l++; r--;
        }
        
        return new String(ch);
    }
}