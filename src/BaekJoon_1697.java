import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1697 {
    static class Node{
        int to, level;

        public Node(int to, int level) {
            this.to = to;
            this.level = level;
        }
    }
    private static List<Node> graph;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        System.out.println(bfs(N, K));
    }
    private static int bfs(int n, int k){
        if(n >= k) return n - k;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n, 0));
        visited[n] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int x1 = cur.to - 1;
            int x2 = cur.to + 1;
            int x3 = cur.to * 2;

            if(x1 == k || x2 == k || x3 == k) return cur.level + 1;

            if(x1 >=0 && !visited[x1]){
                queue.add(new Node(x1, cur.level + 1));
                visited[x1] = true;
            }

            if(x2<= 100000 && !visited[x2]){
                queue.add(new Node(x2, cur.level + 1));
                visited[x2] = true;
            }

            if(x3<= 100000 && !visited[x3]){
                queue.add(new Node(x3, cur.level + 1));
                visited[x3] = true;
            }

        }
        return 0;
    }
}
