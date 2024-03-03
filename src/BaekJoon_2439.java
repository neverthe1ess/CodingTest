import java.util.Scanner;

public class BaekJoon_2439 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int num = N - 1;
        for(int i = 0; i < N; i++, num--){
            for(int j = 0; j < num; j++){
                sb.append(" ");
            }
            for(int j = 0; j <= i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
