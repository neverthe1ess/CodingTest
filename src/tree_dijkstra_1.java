import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tree_dijkstra_1 {
    private static List<Node>[] graph;
    private static int[] dist;
    private static int N, M;
    private static int INF = 1_000_000_000;
    static class Node implements Comparable<Node>{
        private int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }
        dijkstra(1);
        for (int i = 2; i <= N; i++) {
            if(dist[i] == INF){
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist, INF);
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newCost = dist[cur.to] + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }

            }
        }
    }
}
