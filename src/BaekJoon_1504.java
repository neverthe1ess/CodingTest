import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1504 {
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
    private static List<Node>[] graph;
    private static final int INF = 1_000_000_000;
    private static int[] dis;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1 ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int resultPath1 = 0;
        int resultPath2 = 0;

        dijkstra(1);
        resultPath1+= dis[v1];
        resultPath2+= dis[v2];

        dijkstra(v1);
        resultPath1+= dis[v2];
        resultPath2+= dis[N];

        dijkstra(v2);
        resultPath1+= dis[N];
        resultPath2+= dis[v1];

        if(resultPath1 <= 0 || resultPath2 <= 0 || resultPath1 >= INF || resultPath2 >= INF){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(resultPath1, resultPath2));
        }
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis = new int[N + 1];
        Arrays.fill(dis, INF);
        dis[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (dis[cur.to] < cur.cost) continue;

            for (Node next: graph[cur.to]) {
                int newCost = dis[cur.to] + next.cost;
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
