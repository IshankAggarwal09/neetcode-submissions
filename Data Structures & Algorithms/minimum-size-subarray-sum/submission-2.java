class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = 0;
        int minLenWin = Integer.MAX_VALUE;
        while (right < nums.length) {
            currSum += nums[right];
            right++;
            while (currSum >= target) {
                int len = right - left;
                minLenWin = Math.min(minLenWin, len);
                currSum -= nums[left];
                left++;
            }
        }
        return (minLenWin == Integer.MAX_VALUE) ? 0 : minLenWin;
    }
}