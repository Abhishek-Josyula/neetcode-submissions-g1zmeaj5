class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if(search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return ans;
    }

    public boolean search(char[][] board, String word, int i, int j, int processed){
        if (board[i][j] == word.charAt(processed)){

            if (processed == word.length()-1) return true;

            char temp = board[i][j];
            board[i][j] = '#';

            int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
            boolean ans = false;
            for (int[] dir : dirs){
                int ii = dir[0] > 0 ? (int)Math.min(i+dir[0], board.length-1) : (int)Math.max(0, i+dir[0]);
                int jj = dir[1] > 0 ? (int)Math.min(j+dir[1], board[0].length-1) : (int)Math.max(0, j+dir[1]);
                if (!(ii==i && jj==j)){
                    ans = ans || search(board, word, ii, jj, processed+1);
                }
            }

            board[i][j] = temp;

            return ans;
        }else{
            return false;
        }
    }
}
