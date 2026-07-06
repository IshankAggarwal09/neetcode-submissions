class Solution {
    public void helper(int[] nums, int target, int idx, List<List<Integer>> list, List<Integer> ds) {
        if (idx == nums.length) {
            if (target == 0) {
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if (nums[idx] <= target) {
            ds.add(nums[idx]);
            helper(nums, target-nums[idx], idx, list, ds);
            ds.remove(ds.size() - 1);
        }
        helper(nums, target, idx+1, list, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(candidates, target, 0, list, ds);
        return list;
    }
}