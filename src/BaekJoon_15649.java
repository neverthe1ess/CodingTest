import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_15649 {
    private static int M, N;
    private static int[] arr, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new int[N + 1];
        dfs(0);
    }
    private static void dfs(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= N ; i++) {
            if(visited[i] == 0){
                arr[depth] = i;
                visited[i] = 1;
                dfs(depth + 1);
                visited[i] = 0;
            }
        }
    }
}
