import java.util.Scanner;

public class BaekJoon_9663 {
    private static boolean[] flag_a;
    private static boolean[] flag_b;
    private static boolean[] flag_c;
    private static int count;
    private static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        flag_a = new boolean[N];
        flag_b = new boolean[2 * N - 1];
        flag_c = new boolean[2 * N - 1];
        count = 0;
        queen(0);
        System.out.println(count);
    }
    private static void queen(int i){
        for (int j = 0; j < N ; j++) {
            if(!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + N - 1]){
                if(i == N - 1) {
                    count++;
                } else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + N - 1] = true;
                    queen(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + N - 1] = false;
                }
            }
        }
    }
}
