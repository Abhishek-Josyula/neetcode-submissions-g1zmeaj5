class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> deque = new ArrayDeque<>();
        if (nums==null || nums.length < k) {
            return new int[0];
        }
        // init dequeue;
        for (int i=0; i<k; i++){
            while(deque.size()!=0 && deque.peekLast()[1]<nums[i]){
                deque.removeLast();
            }
            int[] t = new int[2];
            t[0] = i;
            t[1] = nums[i];
            deque.add(t);
        }
        int[] res = new int[nums.length-k+1];
        int l=0,r=k-1;
        while(r<nums.length){
            res[l] = deque.peekFirst()[1];
            r++;
            l++;

            while(deque.size()!=0 && deque.peekFirst()[0]<l){
                deque.removeFirst();
            }

            if (r<nums.length){
                while(deque.size()!=0 && deque.peekLast()[1]<nums[r]){
                    deque.removeLast();
                }
                int[] t = new int[2];
                t[0] = r;
                t[1] = nums[r];
                deque.add(t);
            }

        }

        return res;
    }
}
