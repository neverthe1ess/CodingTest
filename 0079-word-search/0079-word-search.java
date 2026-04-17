class Solution {
    private static char[][] targetBoard;
    private static String targetWord;
    private static boolean[][] visited;
    private static int[] dRow = {-1, 1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1}; 
    private static boolean isSuccess;

    public boolean exist(char[][] board, String word) {
        targetBoard = board;
        targetWord = word;
        visited = new boolean[board.length][board[0].length];
        isSuccess = false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(targetBoard[i][j] == word.charAt(0) && !visited[i][j]){
                    visited[i][j] = true;
                    dfs(i, j, 0);
                    visited[i][j] = false;
                }
            }
        }
        if(isSuccess) {
            return true;
        } else {
            return false;
        }
    }
    private static void dfs(int row, int col, int depth){
        if(depth == targetWord.length() - 1){
            isSuccess = true;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(nRow < 0 || nRow >= targetBoard.length || nCol < 0 || nCol >= targetBoard[0].length) continue;
            if(!visited[nRow][nCol] && targetBoard[nRow][nCol] == targetWord.charAt(depth + 1)){
                visited[nRow][nCol] = true;
                dfs(nRow, nCol, depth + 1);
                visited[nRow][nCol] = false;
            }
        }
    }
}