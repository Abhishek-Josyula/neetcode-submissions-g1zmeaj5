class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> row = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> col = new HashMap<>();
        HashMap<String, HashSet<Integer>> sqr = new HashMap<>();

        for (int i = 0; i < board.length; i++){
            
                HashSet<Integer> rowi = row.getOrDefault(i, new HashSet<Integer>());
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.')
                    continue;
                
                // row
                if (rowi.contains(Character.getNumericValue(board[i][j]))){
                    return false;
                } else{
                    rowi.add(Character.getNumericValue(board[i][j]));
                }
                row.put(i, rowi);

                // col
                HashSet<Integer> colj = col.getOrDefault(j, new HashSet<Integer>());
                if (colj.contains(Character.getNumericValue(board[i][j]))){
                    return false;
                } else{
                    colj.add(Character.getNumericValue(board[i][j]));
                }
                col.put(j, colj);

                // sqr
                HashSet<Integer> sqrij = sqr.getOrDefault(String.format("r%dc%d", i/3, j/3), new HashSet<Integer>());
                if (sqrij.contains(Character.getNumericValue(board[i][j]))){
                    return false;
                } else{
                    sqrij.add(Character.getNumericValue(board[i][j]));
                }
                sqr.put(String.format("r%dc%d", i/3, j/3), sqrij);
            }

        }

        return true;
    }
}
