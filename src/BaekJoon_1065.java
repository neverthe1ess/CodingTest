import java.util.Scanner;

public class BaekJoon_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        if(N <= 99){
            result = N;
        } else {
            result = 99;
            for (int i = 100; i <= N ; i++) {
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = (i % 100) % 10;
                if((b - a) == (c - b)){
                    result++;
                }
            }
        }
        System.out.println(result);

    }
}
