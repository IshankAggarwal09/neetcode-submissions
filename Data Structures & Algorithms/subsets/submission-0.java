class Solution {
    private void helper(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (start == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[start]);
        helper(list, tempList, nums, start+1);
        tempList.remove(tempList.size() - 1);
        helper(list, tempList, nums, start+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(list, new ArrayList<>(), nums, 0);
        return list;
    }
}