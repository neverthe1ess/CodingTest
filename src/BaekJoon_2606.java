import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2606 {
    public static int[][] node;
    public static int M,N;
    public static boolean[] visited;
    public static int result = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());


        node = new int[M + 1][M + 1]; // 0은 안씀
        visited = new boolean[M + 1]; // 방문하지 않은 곳은 false

        for(int i = 0; i < N; i ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            node[m][n] = node[n][m] = 1; // 연결되어 있는 것들은 양방향으로 1
        }

        dfs(1);
        System.out.println(result - 1);
    }



    public static void dfs(int x){
        visited[x] = true;
        result += 1;

        for(int i = 1; i<= M; i++){
            if(node[x][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
