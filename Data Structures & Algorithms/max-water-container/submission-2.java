class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int maxWater = 0;
        while (start < end) {
            int h = Math.min(heights[start], heights[end]);
            int w = end - start;
            maxWater = Math.max(maxWater, h*w);
            if (heights[start] < heights[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        return maxWater;
    }
}
