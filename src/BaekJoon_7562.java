import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7562 {
    private static int[] dRows = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dCols = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[][] chessBoard;
    private static int I;
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            I = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            chessBoard = new int[I][I];
            for (int[] ints : chessBoard) {
                Arrays.fill(ints, -1);
            }
            System.out.println(bfs(startY, startX, endY, endX));
        }
    }
    private static int bfs(int sRow, int sCol, int eRow, int eCol){
        if(sRow == eRow && sCol == eCol) return 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(sRow, sCol));
        chessBoard[sRow][sCol] = 0;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 8 ; i++) {
                int nRow = cur.row + dRows[i];
                int nCol = cur.col + dCols[i];

                if(nRow < 0 || nCol < 0 || nRow >= I || nCol >= I) continue;
                if(chessBoard[nRow][nCol] < 0){
                    chessBoard[nRow][nCol] = chessBoard[cur.row][cur.col] + 1;
                    if(nRow == eRow && nCol == eCol) return chessBoard[nRow][nCol];
                    queue.add(new Node(nRow, nCol));
                }
            }
        }
        return 0;
    }
}
