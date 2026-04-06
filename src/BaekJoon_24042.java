import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_24042 {
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
    private static List<Node>[] graph;
    private static long[] dis;
    private static long INF = Long.MAX_VALUE;
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        dis = new long[N + 1];
        Arrays.fill(dis, INF);
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, i));
            graph[b].add(new Node(a, i));
        }
        dijkstra();
        System.out.println(dis[N]);
    }
    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        dis[1] = 0;

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            if(dis[cur.to] < cur.cost) continue;
            for (Node next : graph[cur.to]) {
                long waitTime;
                long curTime = cur.cost % M;
                if(curTime <= next.cost){
                    waitTime = next.cost - curTime;
                } else {
                    waitTime = M - curTime + next.cost;
                }
                long newCost = cur.cost + waitTime + 1;

                if(newCost < dis[next.to]){
                    dis[next.to] = newCost;
                    queue.add(new Node(next.to, newCost));
                }
            }
        }
    }
}
