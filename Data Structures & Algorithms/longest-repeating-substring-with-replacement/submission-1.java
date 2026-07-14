class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int n = s.length();
        int longest = 0;
        while (right < n) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            while ((right-left+1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            longest = Math.max(longest, (right-left+1));
            right++;
        }
        return longest;
    }
}
