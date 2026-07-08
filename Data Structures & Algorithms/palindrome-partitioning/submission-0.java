class Solution {
    public boolean isPalindrome(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    public void helper(String s, int idx, List<List<String>> res, List<String> path) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=idx; i<s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                helper(s, i+1, res, path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, 0, res, path);
        return res;
    }
}