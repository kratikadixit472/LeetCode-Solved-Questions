class Solution {
    public String reverseWords(String s) {
        
        String[] st = s.trim().split(" +");
        
        int l = 0, r = st.length-1;
        while(l < r){
            System.out.print(st[l]+" "+ st[r]+" ");
            String tmp = st[l];
            st[l] = st[r];
            st[r] = tmp;
            l++; r--;
        }
        String ans = String.join(" ", st);
        return ans;
    }
}