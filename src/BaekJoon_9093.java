import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for(int i = 0; i < count; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(st.nextToken());
                sb.reverse();
                result.append(sb + " ");
            }
            result.append("\n");
            }
        System.out.println(result);
    }
}
