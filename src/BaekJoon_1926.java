import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1926 {
    private static int[][] graph;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n, m;
    private static int maxAreaCount, maxAreaSize;
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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        isVisited = new boolean[n][m];
        maxAreaCount = 0;
        maxAreaSize = 0;

        for (int i = 0; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
               graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(graph[i][j] == 0 || isVisited[i][j]) continue;
                maxAreaCount++;
                bfs(i, j);
            }
        }
        System.out.println(maxAreaCount);
        System.out.println(maxAreaSize);

    }
    private static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        isVisited[x][y] = true;
        int areaSize = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();
            areaSize++;

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX < 0 || newY < 0 || newY >= m ||  newX>= n) continue;

                if(graph[newX][newY] == 1 && !isVisited[newX][newY]){
                    q.add(new Node(newX, newY));
                    isVisited[newX][newY] = true;
                }
            }
        }
        maxAreaSize = Math.max(areaSize, maxAreaSize);
    }
}
