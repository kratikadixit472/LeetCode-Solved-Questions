class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>(Arrays.asList(""));
        int n = word.length(), i = 0;
        
        for(int j = 0; j < n; ++j){
            
            if( Character.isDigit(word.charAt(j))){
                i += i < j && word.charAt(i) == '0' ? 1 : 0;
            }
            
            else{
                String subs = word.substring(i, j);

                set.add(subs);

                i = j + 1;
            }
        }
        set.add(word.substring(i));
        
        return set.size() - 1;
    }
}