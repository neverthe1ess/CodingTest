package dynamicprogramming;

import java.util.Scanner;

public class BaekJoon_2748 {
    private static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(fibo(N));

    }
    private static int fibo(int n) {
        if(dp[n] == null){
            dp[n] = fibo(n - 1) + fibo(n - 2);
        }
        return dp[n];
    }
}
