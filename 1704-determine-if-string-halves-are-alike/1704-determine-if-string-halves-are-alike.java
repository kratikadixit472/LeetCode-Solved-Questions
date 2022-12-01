class Solution {
    public boolean halvesAreAlike(String s) {
        
        int n = s.length();
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        
        int avowel = 0, bvowel = 0;
        
        for(char c : a.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                avowel++;
            }
        }
        for(char c : b.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                bvowel++;
            }
        }
        return (avowel == bvowel);
    }
}