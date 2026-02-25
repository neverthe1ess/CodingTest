import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_9020 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int N = sc.nextInt();
            primePrint(N);
        }
    }
    private static void primePrint(int N){
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        
        for (int i = 2; i  *  i <= N ; i++) {
            if(isPrime[i]){
                for (int j = i * i; j <= N ; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int A = N / 2;
        int B = N / 2;
        for (; A >= 2; A--) {
            B = N - A;

            if(isPrime[A] && isPrime[B])
                break;
        }
        System.out.println(A+ " " + B);
    }
}
