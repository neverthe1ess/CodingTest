import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2178_2 {
    private static int[] dx = {0,0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] maze;
    private static int[][] dis;
    private static int N, M;
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        dis = new int[N][M];
        for (int[] di : dis) {
            Arrays.fill(di, -1);
        }

        for (int i = 0; i < N ; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(charArr[j]);
            }
        }
        bfs(0, 0);
        System.out.println(dis[N - 1][M - 1] + 1);
    }
    private static void bfs(int rows, int cols){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(rows, cols));
        dis[rows][cols] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0; i < 4 ; i++) {
                int newRow = cur.x + dx[i];
                int newCol = cur.y + dy[i];
                if(newCol < 0 || newRow < 0 || newCol >= M || newRow >= N) continue;
                if(maze[newRow][newCol] == 1 && dis[newRow][newCol] < 0) {
                    q.add(new Node(newRow, newCol));
                    dis[newRow][newCol] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
