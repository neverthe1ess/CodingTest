import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1600 {
    private static int[][] map;
    private static int[][][] dist;
    private static int[] dNormalRow = {1, -1, 0, 0};
    private static int[] dNormalCol = {0, 0, -1, 1};
    private static int[] dJumpRow = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dJumpCol = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int W, H, K;
    static class Node {
        int row, col, attempt;

        public Node(int row, int col, int attempt) {
            this.row = row;
            this.col = col;
            this.attempt = attempt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        dist = new int[H][W][K + 1];

        for (int i = 0; i < H ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());

    }
    public static int bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.row == H - 1 && cur.col == W - 1) {
                return dist[cur.row][cur.col][cur.attempt] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dNormalRow[i];
                int nCol = cur.col + dNormalCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= H || nCol >= W) continue;
                if(map[nRow][nCol] == 0 && dist[nRow][nCol][cur.attempt] == 0) {
                    dist[nRow][nCol][cur.attempt] = dist[cur.row][cur.col][cur.attempt] + 1;
                    queue.add(new Node(nRow, nCol, cur.attempt));
                }
            }
            if(cur.attempt < K){
                for (int i = 0; i < 8; i++) {
                    int nJumpRow = cur.row + dJumpRow[i];
                    int nJumpCol = cur.col + dJumpCol[i];

                    if(nJumpRow < 0 || nJumpCol < 0 || nJumpRow >= H || nJumpCol >= W) continue;
                    if(map[nJumpRow][nJumpCol] == 0 && dist[nJumpRow][nJumpCol][cur.attempt + 1] == 0){
                        dist[nJumpRow][nJumpCol][cur.attempt + 1] = dist[cur.row][cur.col][cur.attempt] + 1;
                        queue.add(new Node(nJumpRow, nJumpCol, cur.attempt + 1));
                    }
                }
            }
        }
        return -1;
    }
}
