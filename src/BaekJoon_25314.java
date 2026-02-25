import java.util.Scanner;

public class BaekJoon_25314 {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N / 4; i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
