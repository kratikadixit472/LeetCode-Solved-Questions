class Solution {
    public boolean detectCapitalUse(String word) {
        
        int n = word.length(), cnt = 0;
        boolean first = false;
        
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            if(Character.isUpperCase(c)) {
                cnt++;
                if(i == 0) first = true;
            }
        }
        if((cnt == 1 && first) || cnt == n || cnt == 0) return true;
        return false;
    }
}