import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            int avg = sum / N;
            int count = 0;

            for(int i = 0; i < N; i++) {
                if(avg < arr[i]) count++;

            }
            double result = ((double) count / N) * 100;
            String strRes = String.format("%.3f", result);
            sb.append(strRes+ "%\n");
        }
        System.out.println(sb);
    }
}
