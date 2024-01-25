import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1003 {


    public static int[][] arr = new int[41][2]; // 0~40까지 , [][0] -> 0, [][1] -> 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 41; i++){
            arr[i][0] = -1;
            arr[i][1] = -1;
        }

        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(arr[N][0]+ " " + arr[N][1]+"\n");
        }
        System.out.println(sb);
    }
    public static int[] fibonacci(int N) {
        if(arr[N][0] == -1 || arr[N][1] == -1){
            arr[N][0] = fibonacci(N - 1) [0] + fibonacci(N - 2) [0];
            arr[N][1] = fibonacci(N - 1) [1] + fibonacci(N - 2) [1];
        }
        return arr[N];
    }
}
