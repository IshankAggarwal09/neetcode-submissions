class Solution {
    public void helper(int n, int k, int start, List<List<Integer>> ans, List<Integer> ds) {
        if (ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (start > n) {
            return;
        }
        for (int i=start; i<=n; i++) {
            ds.add(i);
            helper(n, k, i+1, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(n, k, 1, ans, ds);
        return ans;
    }
}