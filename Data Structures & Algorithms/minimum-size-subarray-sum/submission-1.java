class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWin = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            currSum += nums[right];
            right++;
            while (currSum >= target) {
                int currLen = right - left;
                minLenWin = Math.min(minLenWin, currLen);
                currSum -= nums[left];
                left++;
            }
        }
        return minLenWin == Integer.MAX_VALUE ? 0 : minLenWin;
    }
}