import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1238 {
    static class Node implements Comparable<Node>{
        int to, cost;

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
    private static int N, M;
    public static void main(String[] args) throws IOException {
        List<Node>[] graph, reverseGraph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            reverseGraph[v].add(new Node(u, w));
        }
        int[] disReversed = dijkstra(X, reverseGraph);
        int[] disFront = dijkstra(X, graph);
        int[] result = new int[N + 1];

        for (int i = 1; i < N + 1 ; i++) {
            result[i] = disFront[i] + disReversed[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1 ; i++) {
            if(result[i] <= INF && result[i] > max){
                max = result[i];
            }
        }
        System.out.println(max);
    }
    private static int[] dijkstra(int target, List<Node>[] targetGraph){
        int[] dis = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dis, INF);
        dis[target] = 0;

        pq.add(new Node(target, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dis[cur.to] < cur.cost) continue;

            for (Node next : targetGraph[cur.to]) {
                int newCost = next.cost + dis[cur.to];
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        return dis;
    }


}
