import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_17835 {
    static class Node implements Comparable<Node>{
        int to;
        long cost;

        public Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    private static int N;
    private static List<Node>[] graph;
    private static final long INF = Long.MAX_VALUE / 2;
    private static long[] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] interviewZones = new int[K];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(u, c));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            interviewZones[i] = Integer.parseInt(st.nextToken());
        }
        dijkstra(interviewZones);
        int maxNumber = 0;
        long maxDistance = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if(dis[i] == INF) continue;

            if (maxDistance < dis[i]) {
                maxDistance = dis[i];
                maxNumber = i;
            }
        }
        System.out.println(maxNumber);
        System.out.println(maxDistance);
    }
    private static void dijkstra(int[] zones){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dis = new long[N + 1];
        Arrays.fill(dis, INF);

        for (int zone : zones) {
            dis[zone] = 0;
            pq.add(new Node(zone, 0));
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dis[cur.to] < cur.cost) continue;
            for (Node next : graph[cur.to]) {
                long newCost = dis[cur.to] + next.cost;
                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
