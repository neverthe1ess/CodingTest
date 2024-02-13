import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Max = -1;
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) {
                    continue;
                }
                for(int k = 0; k < N; k++){
                    if(i == k || j == k) {
                        continue;
                    }
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum <= M && Max <= sum){
                        Max = sum;
                    }
                }
            }
        }

        System.out.println(Max);


    }
}
