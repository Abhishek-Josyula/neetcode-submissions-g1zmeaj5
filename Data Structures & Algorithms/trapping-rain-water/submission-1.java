class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        maxL[0] = height[0];
        maxR[maxR.length-1] = height[height.length-1];

        for (int i = 1; i < maxL.length; i++){
            maxL[i] = Math.max(maxL[i-1], height[i-1]);
        }

        for (int i = maxR.length-2; i>=0; i--){
            maxR[i] = Math.max(maxR[i+1], height[i]);
        }
        
        int ans=0;
        for (int i = 0; i < height.length; i++){
            int wateri = Math.max(0, Math.min(maxL[i], maxR[i])-height[i]);
            ans+=wateri;
        }

        return ans;
    }
}
