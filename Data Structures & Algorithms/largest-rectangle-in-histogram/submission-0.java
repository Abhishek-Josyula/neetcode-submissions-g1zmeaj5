class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftmin = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            leftmin[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftmin[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        int[] rightmin = new int[heights.length];
        for (int i=heights.length-1; i>=0; i--){
            rightmin[i] = heights.length;
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightmin[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            leftmin[i] += 1;
            rightmin[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightmin[i] - leftmin[i] + 1));
        }
        return maxArea;
    }
}
