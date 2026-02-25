package dynamicprogramming;

import java.util.Scanner;

public class BaekJoon_1912 {
    private static int[] arr;
    private static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        dp = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        seqSum(n - 1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if(dp[i] > max){
                max = dp[i];
            }
        }
        System.out.println(max);

    }
    private static int seqSum(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(seqSum(n - 1) + arr[n], arr[n]);
        }
        return dp[n];
    }
}
