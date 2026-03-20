import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tree_dijkstra_2 {
    private static int N, M;
    private static int[] dis;
    private static List<Node>[] graph;
    private static final int INF = 1_000_000_000;

    static class Node implements Comparable<Node>{
        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        private int to, cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        dis = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, weight));
            graph[v].add(new Node(u, weight));
        }
        dijkstra(K);
        for (int i = 1; i <= N; i++) {
            if(dis[i] == INF) {
                System.out.println(-1);
                continue;
            }
            System.out.println(dis[i]);
        }
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();

        Arrays.fill(dis, INF);
        dis[start] = 0;

        nodePriorityQueue.add(new Node(start, 0));
        while(!nodePriorityQueue.isEmpty()){
            Node cur = nodePriorityQueue.poll();
            
            if(dis[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                int newCost = dis[cur.to] + next.cost;
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    nodePriorityQueue.add(new Node(next.to, newCost));
                }
            }
        }



    }
}
