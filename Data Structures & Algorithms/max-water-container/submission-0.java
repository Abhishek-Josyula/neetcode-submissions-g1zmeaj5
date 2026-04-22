class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int waterMAx = Integer.MIN_VALUE;
        while (left < right){
            int waterlr = (right-left)*((int)Math.min(heights[left], heights[right]));
            waterMAx = (int)Math.max(waterMAx, waterlr);

            if (heights[right]>=heights[left]){
                left++;
            }else{
                right--;
            }
        }
        return waterMAx;
    }
}
