import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            StringBuffer sb = new StringBuffer();
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            int result = 1;
            sb.append(n +" = 1");
            for(int i = 2; i <= n / 2; i++){
                if(n % i == 0){
                    result += i;
                    sb.append(" + " + i);
                }
            }
            if(result == n){
                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}
