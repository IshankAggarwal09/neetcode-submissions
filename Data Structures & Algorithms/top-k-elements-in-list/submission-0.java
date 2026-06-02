class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }
            else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        for (int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
