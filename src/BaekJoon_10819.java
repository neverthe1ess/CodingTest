import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10819 {
    private static int threshold;
    private static int[] arr, perm;
    private static boolean[] visited;
    private static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        threshold = N;
        arr = new int[N];
        perm = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        seq(0);
        System.out.println(result);
    }
    private static void seq(int cnt){
        if(cnt == threshold){
            int sum = 0;
            for (int i = 0; i < threshold - 1 ; i++) {
                sum += Math.abs(perm[i] - perm[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < threshold; i++) {
            if(!visited[i]){
                visited[i] = true;
                perm[cnt] = arr[i];
                seq(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
