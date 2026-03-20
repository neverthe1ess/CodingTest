import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1753 {
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
    private static List<Node>[] graph;
    private static int[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        graph[0] = null;
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        dis = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        dijkstra(K);
        for (int i = 1; i <= V ; i++) {
            if(dis[i] == INF){
                System.out.println("INF");
                continue;
            }
            System.out.println(dis[i]);
        }
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
