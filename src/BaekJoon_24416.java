import java.util.Scanner;

public class BaekJoon_24416 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 피보나치 수
        System.out.println(fibonacci(N) + " " +  (N - 2));


    }
    public static int fibonacci(int N){
        if(N == 1 || N == 2){
            return 1;
        } else {
            return fibonacci(N - 1) + fibonacci( N - 2);
        }
    }
}
