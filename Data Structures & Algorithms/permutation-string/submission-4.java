class Solution {
    public boolean isSame(int[] freq1, int[] freq2) {
        for (int i=0; i<26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        int[] winFreq = new int[26];
        for (int i=0; i<s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            winFreq[s2.charAt(i) - 'a']++;
        }
        if (isSame(freq, winFreq)) {
            return true;
        }
        for (int i=s1.length(); i<s2.length(); i++) {
            winFreq[s2.charAt(i) - 'a']++;
            winFreq[s2.charAt(i-s1.length()) - 'a']--;
            if (isSame(freq, winFreq)) {
                return true;
            }
        }
        return false;
    }
}