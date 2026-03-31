import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon_9466_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int count = n;
            int[] graph = new int[n + 1];
            int[] isVisited = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n ; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i <= n ; i++) {
                if(isVisited[i] != 0) continue;

                int cur = i;
                while(isVisited[cur] == 0){
                    isVisited[cur] = 1;
                    cur = graph[cur];
                }

                if(isVisited[cur] == 1){
                    int node = cur;
                    do{
                        count--;
                        node = graph[node];
                    } while (node != cur);
                }

                cur = i;
                while(isVisited[cur] == 1){
                    isVisited[cur] = 2;
                    cur = graph[cur];
                }
            }
            System.out.println(count);
        }
    }
}
