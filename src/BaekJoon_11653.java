import java.util.Scanner;

public class BaekJoon_11653{
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();


    }
    static void primeDecomposite(int N){
        int i = (int) Math.sqrt(N);
        int result = 0;
        while(N % i != 0){
            i--;
            result = N / i;
        }
        if(i != 1) {
            System.out.println( );
            return;
        } else {
            primeDecomposite(i);
            primeDecomposite(result);
        }
    }
}
