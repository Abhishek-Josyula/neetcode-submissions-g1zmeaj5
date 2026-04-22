class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String lowerS = s.toLowerCase();
        for (int i = 0; i < lowerS.length(); i++){
            char cI = lowerS.charAt(i);
            
            //  lower and digits
            if (((cI-'a') < 26 && (cI-'a')>=0) || ((cI-'0') < 10 && (cI-'0')>=0)){
                sb.append(cI);
            }
        }

        String processedStr = sb.toString();
        int left = 0;
        int right = processedStr.length()-1;

        while (left<=right){
            if(processedStr.charAt(left)!=processedStr.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }

        return true;
    }
}
