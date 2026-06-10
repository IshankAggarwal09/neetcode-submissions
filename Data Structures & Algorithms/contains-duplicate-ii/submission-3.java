class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        for (int j=0; j<n; j++) {
            if (j - i > k) {
                set.remove(nums[i]);
                i++;
            }
            if (set.contains(nums[j])) {
                return true;
            }
            set.add(nums[j]);
        }
        return false;
    }
}