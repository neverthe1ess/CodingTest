import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9461 {

    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            arr = new long[101];
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            sb.append(calSeq(N) + "\n");
        }
        System.out.println(sb);
    }

    public static long calSeq(int N){
        for(int i = 4; i <= N; i++){
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        return arr[N];
    }
}
