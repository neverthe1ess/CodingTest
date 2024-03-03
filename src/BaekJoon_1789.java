import java.util.Scanner;

public class BaekJoon_1789 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long S = sc.nextInt();
        long sum = 0;

        if(S == 1) System.out.println(1);
        else {
            for(int i = 1; i <= S; i++){
                sum += i;
                if(sum > S) {
                    System.out.println(i - 1);
                    break;
                }
            }
        }





    }
}
