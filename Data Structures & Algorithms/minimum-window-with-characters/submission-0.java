class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[256];
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int sIndex = -1;
        for (int i=0; i<t.length(); i++) {
            freq[t.charAt(i)]++;
        }
        while (right < s.length()) {
            if (freq[s.charAt(right)] > 0) {
                count++;
            }
            freq[s.charAt(right)]--;
            while (count == t.length()) {
                if (right-left+1 < minLen) {
                    minLen = right - left + 1;
                    sIndex = left;
                }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
