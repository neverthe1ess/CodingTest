import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i < 11; i++){
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        while(T-- >0){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n] +"\n");
        }
        System.out.println(sb);
    }
}
