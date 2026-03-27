import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7569 {
    private static int[] dPage = {0, 0, 0, 0, 1, -1};
    private static int[] dRow = {1, -1, 0, 0, 0, 0};
    private static int[] dCol = {0, 0, -1, 1, 0, 0};
    private static int[][][] garage;
    private static int[][][] dist;
    private static int N, H, M;
    private static int max;
    static class Node {
        int page, row, col;

        public Node(int page, int row, int col) {
            this.page = page;
            this.row = row;
            this.col = col;
        }
    }
    private static Queue<Node> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        queue = new ArrayDeque<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        garage = new int[H][N][M];
        dist = new int[H][N][M];
        max = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M ; k++) {
                    garage[i][j][k] = Integer.parseInt(st.nextToken());
                    dist[i][j][k] = -1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N ; j++) {
                for (int k = 0; k < M ; k++) {
                    if(dist[i][j][k] == -1 && garage[i][j][k] == 1){
                        queue.add(new Node(i, j, k));
                        dist[i][j][k] = 0;
                    }
                }
            }
        }
        bfs();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(dist[i][j][k] == -1 && garage[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(max);
    }
    private static void bfs(){
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 6 ; i++) {
                int nPage = cur.page + dPage[i];
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nPage < 0 || nRow < 0 || nCol < 0 || nPage >= H || nRow >= N || nCol >= M) continue;
                if(dist[nPage][nRow][nCol] < 0 && garage[nPage][nRow][nCol] == 0){
                    dist[nPage][nRow][nCol] = dist[cur.page][cur.row][cur.col] + 1;
                    queue.add(new Node(nPage, nRow, nCol));
                    max = Math.max(dist[nPage][nRow][nCol], max);
                }
            }
        }
    }
}
