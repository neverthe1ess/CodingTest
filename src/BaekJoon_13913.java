import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[100_001];
        int[] prev = new int[100_001];
        Arrays.fill(dist, -1);
        queue.add(N);
        dist[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == K) {
                System.out.println(dist[cur]);
                break;
            }

            for (int nx : new int[]{cur * 2, cur - 1, cur + 1}) {
                if (nx < 0 || nx > 100_000 || dist[nx] != -1) continue;
                queue.add(nx);
                dist[nx] = dist[cur] + 1;
                prev[nx] = cur;
            }
        }
        List<Integer> path = new ArrayList<>();
        int cur = K;
        while (cur != N) {
            path.add(cur);
            cur = prev[cur];
        }
        path.add(cur);
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (Integer i : path) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
