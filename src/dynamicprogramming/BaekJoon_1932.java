package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1932 {
    private static int[][] arr;
    private static Integer[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.println(searchMaxSum(0,0));
    }
    private static int searchMaxSum(int row, int col) {
        if(row == n - 1) return dp[row][col];

        if(dp[row][col] == null){
            dp[row][col] = Math.max(searchMaxSum(row + 1, col), searchMaxSum(row + 1, col + 1)) + arr[row][col];
        }
        return dp[row][col];
    }
}
