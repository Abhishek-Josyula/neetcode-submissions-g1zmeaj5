public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        if (piles==null || piles.Length == 0) return -1;
        int start = 1, end = piles.Max();

        while (start<=end){
          int mid = start + (end-start)/2;
          int h1 = 0;

          for (int i = 0; i < piles.Length; i++){
            h1+=(int)Math.Ceiling((double)piles[i]/mid);
          }

          if (h1>h){
            start = mid+1;
          } else{
            end = mid-1;
          }
        
        }

        return start;
    }
}
