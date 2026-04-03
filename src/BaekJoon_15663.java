import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_15663 {
    private static int M, N;
    private static int[] list, series;
    private static boolean[] visited;
    private static StringBuilder sb;
    private static Set<int[]> set;
    private static int lastAccessed = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        series = new int[M];
        visited = new boolean[N];
        dfs(0);
        System.out.println(sb);


    }

    private static void dfs(int depth){
        if(depth == M){
            for (int j : series) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {
            int element = list[i];
            if (visited[i]) continue;
            if( element == prev) continue;
            visited[i] = true;
            series[depth] = element;
            prev = element;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
