import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_13549 {
    private static int[] dist;
    private static int[] dx = {-1, 1};
    private static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[100_001];
        Arrays.fill(dist, -1);
        bfs(N);
        System.out.println(dist[K]);
    }
    private static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == K ){
                return;
            }
            int nx = cur * 2;

            if(nx >= 0 && nx <= 100000 && dist[nx] < 0) {
                dist[nx] = dist[cur];
                queue.add(nx);
            }

            for (int i = 0; i < 2; i++) {
                nx = cur + dx[i];

                if(nx >= 0 && nx <= 100000 && dist[nx] < 0){
                    dist[nx] = dist[cur] + 1;
                    queue.add(nx);
                }
            }
        }
    }
}
