class Solution {
    public void helper(int[] nums, int idx, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i=idx; i<nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            ds.add(nums[i]);
            helper(nums, i+1, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums, 0, ans, ds);
        return ans;
    }
}