import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1929 {

    public static int[] prime;  //value : 0은 소수, 1은 소수가 아닌 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new int[N + 1]; // 0 ~ n까지
        test_prime();

        prime[0] = 1;
        prime[1] = 1;


        for(int i = M; i <= N; i++){
            if(prime[i] == 0){
                System.out.println(i);
            }
        }

    }
    public static void test_prime(){
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {   // 제곱근까지만 2의 배수, 3의 배수, ~제곱근의 배수, 자신은 제외
            if(prime[i] == 1) continue; // 이미 분류된 소수가 아닌 수는 넘어가기
            for(int j = i * i;  j < prime.length; j += i){
                prime[j] = 1;
            }
        }
    }
}
