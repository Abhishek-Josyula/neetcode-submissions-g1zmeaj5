class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rowl = 0, rowr = matrix.length-1;
        while (rowl<=rowr){
            int mid = rowl + (rowr-rowl)/2;
            if (matrix[mid][0] == target){
                return true;
            }
            else if (matrix[mid][0]>target){
                rowr = mid-1;
            } else {
                rowl = mid+1;
            }
        }
        if(rowr<0) return false;
        int[] rowS = matrix[rowr];
        int left = 0; int right=rowS.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(rowS[mid]==target){
                return true;
            } else if (rowS[mid]>target){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return false;
    }
}
