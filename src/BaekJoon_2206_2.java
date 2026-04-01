import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2206_2 {
    static class Node{
        int row, col, attempt;

        public Node(int row, int col, int attempt) {
            this.row = row;
            this.col = col;
            this.attempt = attempt;
        }
    }
    private static int[][] map;
    private static int[][][] dist;
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1};
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M ; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        System.out.println(bfs());
    }
    private static int bfs(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.row == N - 1 && cur.col == M - 1){
                return dist[cur.row][cur.col][cur.attempt];
            }

            for (int i = 0; i <4; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= M) continue;
                if(map[nRow][nCol] == 0 && dist[nRow][nCol][cur.attempt] == 0){
                    dist[nRow][nCol][cur.attempt] = dist[cur.row][cur.col][cur.attempt] + 1;
                    queue.add(new Node(nRow, nCol, cur.attempt));
                }
                if(map[nRow][nCol] == 1 && cur.attempt == 0 && dist[nRow][nCol][cur.attempt + 1] == 0){
                    dist[nRow][nCol][cur.attempt + 1] = dist[cur.row][cur.col][cur.attempt] + 1;
                    queue.add(new Node(nRow, nCol, cur.attempt + 1));
                }
            }
        }
        return -1;
    }
}
