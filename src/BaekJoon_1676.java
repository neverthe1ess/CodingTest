import java.util.Scanner;

public class BaekJoon_1676 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        while(N >= 5){
            result += N / 5;
            N /= 5;
        }
        System.out.println(result);
    }
}
