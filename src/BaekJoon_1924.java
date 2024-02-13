import java.util.Scanner;

public class BaekJoon_1924 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sum = 0;
        int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] result = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        for(int i = 0; i < x - 1; i++){
            sum += arr[i];
        }
        System.out.println(result[(sum + y) % 7]);

    }
}
