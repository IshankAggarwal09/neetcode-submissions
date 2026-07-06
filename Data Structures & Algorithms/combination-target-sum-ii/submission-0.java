class Solution {
    public void helper(int[] nums, int target, int idx, List<List<Integer>> list, List<Integer> ds) {
        if (target == 0) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for (int i=idx; i<nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            ds.add(nums[i]);
            helper(nums, target-nums[i], i+1, list, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, list, ds);
        return list;
    }
}