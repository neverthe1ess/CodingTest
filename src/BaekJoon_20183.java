import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_20183 {
    static class Node implements Comparable<Node>{
        private int to;
        private long cost;

        public Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    private static int A, B, N, M;
    private static long C;
    private static final long INF = Long.MAX_VALUE;
    private static List<Node>[] graph;
    private static long[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        int left = 1;
        int right = 1_000_000_000;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(dijkstra(mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(left >= 1_000_000_001){
            System.out.println(-1);
        } else {
            System.out.println(left);
        }

    }
    private static boolean dijkstra(int maxDeposit){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis = new long[N + 1];
        Arrays.fill(dis, INF);
        dis[A] = 0;

        pq.add(new Node(A, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dis[cur.to] < cur.cost) continue;
            for (Node next : graph[cur.to]) {
                if(next.cost > maxDeposit) continue;
                long newCost = dis[cur.to] + next.cost;
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

        return dis[B] <= C;
    }
}
