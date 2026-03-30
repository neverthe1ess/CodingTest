import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_14442 {
    static class Node {
        int row, col, attempt;

        public Node(int row, int col, int attempt) {
            this.row = row;
            this.col = col;
            this.attempt = attempt;
        }
    }
    public static void main(String[] args) throws IOException {
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] dist = new int[K + 1][N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M ; j++) {
                map[i][j] = chars[j] - '0';
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 0));
        dist[0][0][0] = 1;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.row == N - 1 && cur.col == M - 1) {
                System.out.println(dist[cur.attempt][cur.row][cur.col]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= M) continue;
                if(map[nRow][nCol] == 0 && dist[cur.attempt][nRow][nCol] == 0){
                    dist[cur.attempt] [nRow][nCol]= dist[cur.attempt][cur.row][cur.col] + 1;
                    queue.add(new Node(nRow, nCol, cur.attempt));
                }

                if(map[nRow][nCol] == 1 && cur.attempt < K && dist[cur.attempt + 1][nRow][nCol] == 0){
                    dist[cur.attempt + 1][nRow][nCol] = dist[cur.attempt][cur.row][cur.col] + 1;
                    queue.add(new Node(nRow, nCol, cur.attempt + 1));
                }
            }
        }
        System.out.println(-1);
    }
}
