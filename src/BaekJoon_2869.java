import java.util.Scanner;

public class BaekJoon_2869{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        double B = sc.nextDouble();
        int V = sc.nextInt();
        System.out.println((int)Math.ceil((V - B) / (A - B)));
    }
}
