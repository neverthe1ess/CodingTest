import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon_1261 {
    private static int[][] graph;
    private static int[][] dis;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static final int INF = 1_000_000_000;
    static class Node implements Comparable<Node>{
        int x, y, weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    private static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][M + 1];
        dis = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1;  j <= M; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j - 1));
            }
        }

        dijkstra(1, 1);
        System.out.println(dis[N][M]);

    }
    private static void dijkstra(int startX, int startY){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] di : dis) {
            Arrays.fill(di, INF);
        }
        dis[startY][startX] = 0;
        pq.add(new Node(startX, startY, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dis[cur.y][cur.x] < cur.weight) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y+ dy[i];

                if(nx < 1 || nx > M  || ny < 1 || ny > N) continue;
                int newCost = dis[cur.y][cur.x] + graph[ny][nx];
                if(newCost < dis[ny][nx]){
                    dis[ny][nx] = newCost;
                    pq.add(new Node(nx, ny, newCost));
                }
            }
        }
    }
}
