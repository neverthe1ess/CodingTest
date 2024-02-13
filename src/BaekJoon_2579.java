import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairValue = new int[N + 1];
        int[] stairSum = new int[N + 1];

        for(int i = 1; i <= N; i++){
            stairValue[i] = Integer.parseInt(br.readLine());
        }

        stairSum[1] = stairValue[1];

        //n이 1되면 index 2의 값을 더 할수 없음
        if(N >= 2){
            stairSum[2] = stairValue[1] + stairValue[2];
        }

        for(int i = 3; i <= N; i++){
            stairSum[i] = Math.max(stairSum[i - 2], stairSum[i - 3] + stairValue[i - 1]) + stairValue[i];
        }

        System.out.println(stairSum[N]);

    }
}
