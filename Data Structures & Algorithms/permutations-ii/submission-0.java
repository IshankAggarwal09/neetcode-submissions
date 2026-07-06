class Solution {
    public void helper(int[] nums, boolean[] used, List<List<Integer>> ans, List<Integer> ds) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            ds.add(nums[i]);
            helper(nums, used, ans, ds);
            ds.remove(ds.size() - 1);
            used[i] = false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums, new boolean[nums.length], ans, ds);
        return ans;
    }
}