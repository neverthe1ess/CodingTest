import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        while(N-- > 0){
            int number = Integer.parseInt(br.readLine());
            arr[number]++;
        }

        for (int i = 1; i < 10001; i++) {
            if(arr[i] > 0 ){
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}
