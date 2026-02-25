import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] integers = new int[N];
        while(N-- > 0){
            integers[N] = sc.nextInt();
        }
        Arrays.sort(integers);
        for (int integer : integers) {
            System.out.println(integer);
        }
    }
}
