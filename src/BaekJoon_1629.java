import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1629 {
    private static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(multiply(A, B));
    }
    private static long multiply(long target, long count){
        if(count == 1){
            return target % C;
        }
        long result = multiply(target, count / 2) % C;
        if(count % 2 == 0){
            return (result * result) % C;
        }
        return (target *  ((result * result) % C) % C);
    }
}
