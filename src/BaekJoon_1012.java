import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1012 {
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1};
    static class Node{
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] grid = new int[N][M];
            boolean[][] isVisited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());
                grid[row][col] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(grid[i][j] == 1 && !isVisited[i][j]) {
                        count++;
                        Queue<Node> queue = new ArrayDeque<>();
                        isVisited[i][j] = true;
                        queue.add(new Node(i, j));

                        while(!queue.isEmpty()){
                            Node cur = queue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nRow = cur.row + dRow[k];
                                int nCol = cur.col + dCol[k];

                                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= M) continue;
                                if(!isVisited[nRow][nCol] && grid[nRow][nCol] == 1){
                                    isVisited[nRow][nCol] = true;
                                    queue.add(new Node(nRow, nCol));
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
