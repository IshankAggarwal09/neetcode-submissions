class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = -1;
        int end = 0;
        for (int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int daysNeeded = 1;
            int currWeight = 0;
            for (int weight : weights) {
                if (currWeight + weight > mid) {
                    daysNeeded++;
                    currWeight = 0;
                }
                currWeight += weight;
            }
            if (daysNeeded > days) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}