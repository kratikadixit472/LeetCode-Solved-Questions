class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] arr = path.split("/");

        for (String s : arr) {

            if (s.equals(".") || s.isEmpty()) {
                continue;
            } else if (s.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {

                stack.add(s);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}