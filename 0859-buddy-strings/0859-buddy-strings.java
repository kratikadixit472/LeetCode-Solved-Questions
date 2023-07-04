class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<Character>();
            for (char c : s.toCharArray()) set.add(c);
            return set.size() < s.length();
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) if (s.charAt(i) != goal.charAt(i)) diff.add(i);
        return diff.size() == 2 && s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}