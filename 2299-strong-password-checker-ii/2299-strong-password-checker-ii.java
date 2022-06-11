class Solution {
    public boolean strongPasswordCheckerII(String password) {
        Set<Character> set = new HashSet<>();
        
        if(password.length() < 8) return false;
        
        for(int i=0; i<password.length(); i++){
            char ch = password.charAt(i);
            
            if(i > 0 && ch == password.charAt(i-1)){
                return false;
            }
            else if(Character.isDigit(ch)){
                set.add('d');
            }
            else if(Character.isLowerCase(ch)){
                set.add('l');
            }
            else if(Character.isUpperCase(ch)){
                set.add('u');
            }
            else if("!@#$%^&*()-+".contains(ch + "")){
                set.add('s');
            }
        }
        
        return ((set.size() == 4) && (password.length() >= 8));
    }
}