import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_11779 {
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
    private static int[] dis;
    private static int[] prev;
    private static final int INF = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dis = new int[n + 1];
        prev = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dis[end]);
        reverseTrace(end);
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
        int prevIndex = end;

        while(prevIndex != 0){
            path.add(prevIndex);
            prevIndex = prev[prevIndex];
        }

        Collections.reverse(path);
        System.out.println(path.size());
        for (Integer i : path) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
