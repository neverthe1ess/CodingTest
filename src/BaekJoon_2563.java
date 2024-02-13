import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int x, y;
        int result = 0;
        boolean[][] arr = new boolean[100][100];

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    if(!arr[j][i]){
                        result++;
                        arr[j][i] = true;
                    }
                }
            }
        }
        System.out.println(result);


    }

}
