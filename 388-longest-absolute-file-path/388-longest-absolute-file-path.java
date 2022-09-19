public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        int level = 0;
        stack.push(0); 
        for (String s: arr) {
            
            int numOfTabs = s.lastIndexOf("\t") + 1;
         
            level = numOfTabs + 1;
            System.out.println("level "+numOfTabs +" "+ level+ s);
            
            while (level < stack.size()) stack.poll(); 
            System.out.println("peek "+ stack.peek());
            
            int curLen = stack.peek() + s.length() - numOfTabs + 1;
            System.out.println("curLen "+ curLen+" "+ s.length());
            
            stack.push(curLen);
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen - 1);
        }
        return maxLen;
    }
}