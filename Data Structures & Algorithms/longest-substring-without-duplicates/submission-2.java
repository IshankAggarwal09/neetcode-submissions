class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int longest = 0;
        while (right < n) {
            int len = 0;
            if (map.containsKey(s.charAt(right))) {
                if (left <= map.get(s.charAt(right))) {
                    left = map.get(s.charAt(right)) + 1;
                }
                len = 1;
            }
            map.put(s.charAt(right), right);
            len = right - left + 1;
            longest = Math.max(longest, len);
            right++;
        }
        return longest;
    }
}