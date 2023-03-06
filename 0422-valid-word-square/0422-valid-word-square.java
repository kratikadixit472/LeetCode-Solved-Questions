class Solution {
    public boolean validWordSquare(List<String> words) {
        
        int n = words.size();
        
        for(int r = 0; r < n; r++){
            for(int c = 0 ; c < words.get(r).length(); c++){
                if(c >= n || r >= words.get(c).length() || words.get(r).charAt(c) != words.get(c).charAt(r)) return false;
            }
        }
        return true;
    }
}

/*
 ["abcd",
  "bnrt",
  "crmy",
  "dtye"]
*/