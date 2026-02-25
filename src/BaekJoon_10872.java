import java.util.Scanner;

public class BaekJoon_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = fact(N);
        System.out.println(result);
    }
    private static int fact(int N){
        if(N < 1) return 1;
        return fact(N - 1) * N;
    }
}
