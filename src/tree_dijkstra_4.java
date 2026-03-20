import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class tree_dijkstra_4 {
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
    private static List<Node>[] graph;
    private static final int INF = 1_000_000_000;
    private static int[] dis;
    private static int[] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1 ; i++) {
            graph[i] = new ArrayList<>();
        }
        dis = new int[N + 1];
        prev = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, weight));
            graph[v].add(new Node(u, weight));
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        dijkstra(A);
        System.out.println(dis[B]);
        reverseTrace(B);
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
                    prev[next.to] = cur.to;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }

    }
    private static void reverseTrace(int end){
        StringBuilder sb = new StringBuilder();
        List<Integer> path = new ArrayList<>();

        int curIndex = end;

        while(curIndex != 0){
            path.add(curIndex);
            curIndex = prev[curIndex];
        }
        Collections.reverse(path);
        for (Integer i : path) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
