import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10830 {
    private static int[][] matrix;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] result = pow(matrix, B);

        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[][] pow(int[][] matrix, long exponent){
        if(exponent == 1) return matrix;

        int[][] powArr = pow(matrix, exponent / 2);

        if(exponent % 2 == 0){
            return multiply(powArr, powArr);
        } else {
            return multiply(multiply(powArr, powArr), matrix);
        }
    }

    private static int[][] multiply(int[][] a, int[][] b){
        int[][] result = new int[N][N];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]) % 1000;
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }
}
