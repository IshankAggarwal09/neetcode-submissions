class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean duplicate = false;
        for (int num : nums) {
            if (set.contains(num)) {
                duplicate = true;
                break;
            }
            set.add(num);
        }
        return duplicate;
    }
}