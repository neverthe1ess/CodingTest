import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1920 {
    private static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(search(target, 0, A.length - 1) ? 1 : 0);
        }
    }
    private static boolean search(int X,int p, int r){
        if(p > r) return false;
        int target = (p + r) / 2;
        if(A[target] == X){
            return true;
        } else if(A[target] < X){
            return search(X, target + 1, r);
        } else {
            return search(X, p, target - 1);
        }
    }
}
