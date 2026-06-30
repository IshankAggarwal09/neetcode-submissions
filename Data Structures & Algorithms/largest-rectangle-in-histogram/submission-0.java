class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        nse[n-1] = n;
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for (int i=n-2; i>=0; i--) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                    nse[i] = n;
            }   
            else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            stack.pop();
        }
        int[] pse = new int[n];
        pse[0] = -1;
        stack.push(0);
        for (int i=1; i<n; i++) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                    pse[i] = -1;
            }
            else {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for (int i=0; i<n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea; 
    }
}