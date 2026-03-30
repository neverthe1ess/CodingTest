import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_9466 {
    private static List<Integer>[] graph;
    private static int[] state;
    private static int cycleCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            cycleCount = 0;
            int n = Integer.parseInt(br.readLine());
            graph = new ArrayList[n + 1];
            for (int i = 1; i < n + 1 ; i++) {
                graph[i] = new ArrayList<>();
            }
            state = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1 ; i++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i < n + 1; i++) {
                if(state[i] == 0){
                    dfs(i);
                }
            }
            System.out.println(n - cycleCount);
        }
    }
    private static void dfs(int start){
        state[start] = 1;

        for (int next : graph[start]) {
            if(state[next] == 0){
                dfs(next);
            } else if(state[next] == 1){
                int cur = next;
                cycleCount++;
                while(cur != start){
                    cycleCount++;
                    cur = graph[cur].get(0);
                }
            }
        }
        state[start] = 2;
    }
}
