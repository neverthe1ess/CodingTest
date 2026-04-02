import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_14889 {
    private static int[] arr;
    private static boolean[] visited;
    private static int min, N;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        arr = new int[N / 2];
        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 1);
        System.out.println(min);
    }
    private static void dfs(int depth, int start){
        if(depth == N / 2){
            min = Math.min(min, sum(arr));
            return;
        }
        for (int i = start; i <= N ; i++) {
            arr[depth] = i;
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    private static int sum(int[] arr){
        int sumTeam1 = 0;
        int teamSize = N / 2;
        for (int i = 0; i < teamSize; i++) {
            for (int j = i + 1; j < teamSize; j++) {
                sumTeam1 += map[arr[i]][arr[j]] +map[arr[j]][arr[i]];
            }
        }

        List<Integer> team2 = new ArrayList<>();
        for (int i = 1; i <= N ; i++) {
            if(!visited[i]) team2.add(i);
        }
        int sumTeam2 = 0;
        for (int i = 0; i < teamSize;  i++) {
            for (int j = i + 1; j < teamSize; j++) {
                int a = team2.get(i);
                int b = team2.get(j);
                sumTeam2 += map[a][b] +map[b][a];
            }
        }

        return Math.abs(sumTeam1 - sumTeam2);
    }
}
