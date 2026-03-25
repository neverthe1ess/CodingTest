import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_7576 {
    private static int M, N;
    private static int[][] graph;
    private static int[] dRows = {0, 0, -1, 1};
    private static int[] dCols = {1, -1, 0, 0};
    private static boolean[][] isVisited;

    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new ArrayDeque<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        isVisited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M ; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    q.add(new Node(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + dRows[i];
                int newCol = cur.col + dCols[i];

                if(newRow < 0 || newCol < 0 || newCol >= M || newRow >= N) continue;
                if(graph[newRow][newCol] == 0 && !isVisited[newRow][newCol]){
                    q.add(new Node(newRow, newCol));
                    graph[newRow][newCol] = graph[cur.row][cur.col] + 1;
                    isVisited[newRow][newCol] = true;
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, graph[i][j]);
            }
        }
        System.out.println(max - 1);
    }
}
