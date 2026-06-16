class Solution {
    public String simplifyPath(String path) {
        String[] token = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s: token) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (!s.equals("..")) {
                stack.push(s);
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }
}