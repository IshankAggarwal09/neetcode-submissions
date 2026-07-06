class Solution {
    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<>(), ans);
        return ans;
    }
}