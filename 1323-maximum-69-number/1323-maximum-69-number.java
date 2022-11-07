class Solution {
    public int maximum69Number (int num) {
        
        String s = Integer.toString(num);
        char[] ch = s.toCharArray();
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(cnt == 0 && ch[i] == '6'){
                ch[i] = '9';
                cnt++;
            }
        }
        s = new String(ch);
        return Integer.valueOf(s);
    }
}