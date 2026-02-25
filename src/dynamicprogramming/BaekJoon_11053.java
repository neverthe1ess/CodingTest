package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11053 {
    private static int[] arrSeq;
    private static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String sequence = br.readLine();
        StringTokenizer st = new StringTokenizer(sequence);
        arrSeq = new int[N];
        dp = new Integer[N];

        for (int i = 0; i < N; i++) {
            arrSeq[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            mostLongSeq(i);
        }

        int maxLength = dp[0];
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }

    private static int mostLongSeq(int element){
        if(dp[element] == null){
            dp[element] = 1;

            for (int i = element - 1; i >= 0 ; i--) {
                if(arrSeq[i] < arrSeq[element]){
                    dp[element] = Math.max(dp[element], mostLongSeq(i) + 1);
                }
            }
        }
        return dp[element];
    }
}
