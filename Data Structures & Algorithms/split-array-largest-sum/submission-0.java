class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) {
            int mid = low + (high-low)/2;
            int pieces = 1;
            int sum = 0;
            for (int i=0; i<n; i++) {
                if (nums[i] + sum <= mid) {
                    sum += nums[i];
                }
                else {
                    pieces++;
                    sum = nums[i];
                }
            }
            if (pieces > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}