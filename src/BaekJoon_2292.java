import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int firstNum = 2;
        int stage = 1;


        while (firstNum <= N){
            firstNum = firstNum + (6 * stage);
            stage++;
        }

        System.out.println(stage);


    }
}
