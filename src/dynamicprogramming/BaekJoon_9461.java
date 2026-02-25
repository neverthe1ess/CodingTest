package dynamicprogramming;

import java.util.Scanner;

public class BaekJoon_9461 {
    private static Long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        dp = new Long[150];
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        while (T-- > 0) {
            int N = sc.nextInt();
            sb.append(MemoWave(N)).append("\n");
        }
        System.out.println(sb);
    }
    private static long MemoWave(int n){
        if(dp[n] == null){
            dp[n] = MemoWave(n - 2) + MemoWave(n - 3);
        }
        return dp[n];
    }

    private static int noMemoWave(int n){
        if(n <= 3){
            return 1;
        } else {
            return noMemoWave(n-2) + noMemoWave(n-3);
        }
    }
}
