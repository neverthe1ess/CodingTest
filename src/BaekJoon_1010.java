import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1010 {

    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[30][30];
        for(int i = 0; i < 30; i++){
            arr[i][i] = 1;
            arr[0][i] = 1;
        }

        StringBuffer sb = new StringBuffer();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(combination(N, M)+"\n");
        }
        System.out.println(sb);
    }

    public static int combination(int N, int M){
        for(int i = 1; i <= N; i++){
            for(int j = 2; j <= M; j++){
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j - 1];
            }
        }
        return arr[N][M];
    }
}
