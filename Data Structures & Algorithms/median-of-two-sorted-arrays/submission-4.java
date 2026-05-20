class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null&&nums2==null) return Double.MIN_VALUE;
        if (nums1.length==0 && nums2.length==0) return Double.MIN_VALUE;
        if (nums1==null || nums1.length==0){
            if (nums2.length%2==0){
                int i1=nums2.length/2;
                int i2=i1-1;
                return (double)(nums2[i1]+nums2[i2])/2;
            } else{
                int i1=nums2.length/2;
                return (double)(nums2[i1]);
            }
        }

        if (nums2==null || nums2.length==0){
            if (nums1.length%2==0){
                int i1=nums1.length/2;
                int i2=i1-1;
                return (double)(nums1[i1]+nums1[i2])/2;
            } else{
                int i1=nums1.length/2;
                return (double)(nums1[i1]);
            }
        }

        int mergedN = nums1.length+nums2.length;
        int pleftN = 0;
        if (mergedN%2==0){
            pleftN = mergedN/2;
        }else {
            pleftN = (mergedN+1)/2;
        }

        if (nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int l = -1;
        int r = nums1.length-1;

        while(l<=r){
            int mid = l + (r-l+1)/2;
            int p2 = (mergedN+1)/2 - mid-2;
            //mid=0,nums1.length
            //p2=0,nums2.length;

            int nums1LeftMax = (mid >= 0) ? nums1[mid] : Integer.MIN_VALUE;
            int nums2LeftMax = (p2 >= 0) ? nums2[p2] : Integer.MIN_VALUE;
            int nums1RightMin = (mid + 1 < nums1.length) ? nums1[mid + 1] : Integer.MAX_VALUE;
            int nums2RightMin = (p2 + 1 < nums2.length) ? nums2[p2 + 1] : Integer.MAX_VALUE;

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                if (mergedN % 2 == 0) {
                    int maxLeft = Math.max(nums1LeftMax, nums2LeftMax);
                    int minRight = Math.min(nums1RightMin, nums2RightMin);
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return (double) Math.max(nums1LeftMax, nums2LeftMax);
                }
            } else if (nums1[mid]>nums2[p2+1]){
                r = mid-1;
            } else{
                l = mid+1;
            }
        }

        return 0;
    }
}
