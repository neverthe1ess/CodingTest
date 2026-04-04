import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_15664 {
    private static int N, M;
    private static int[] list, arr;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        dfs(0, 0);
        System.out.println(sb);
    }
    private static void dfs(int depth, int start){
        if(depth == M){
            for (int i : arr) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            if(prev == list[i]) continue;
            arr[depth] = i;
            prev = list[arr[depth]];
            dfs(depth + 1, i + 1);
        }
    }
}
