import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tree_dijkstra_3 {
    static class Node implements Comparable<Node>{
        private int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    private static final int INF = 1_000_000_000;
    private static int[] dis;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(u, weight));
        }
        dijkstra(N);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] != INF) max = Math.max(max, dis[i]);
        }
        System.out.println(max);

    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dis, INF);
        dis[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dis[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newCost = dis[cur.to] + next.cost;
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
