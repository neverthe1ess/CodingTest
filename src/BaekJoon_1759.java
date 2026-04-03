import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_1759 {
   private static int L, C;
   private static int[] combi;
   private static char[] chars;
   private static StringBuilder sb;
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        combi = new int[L];
        st = new StringTokenizer(br.readLine());
        chars = new char[C];
       for (int i = 0; i < C ; i++) {
           chars[i] = st.nextToken().charAt(0);
       }
        Arrays.sort(chars);
        dfs(0, 0);
       System.out.println(sb);
   }

    public static void dfs(int depth, int start){
        if(depth == L){
            int count = 0;
            StringBuilder line = new StringBuilder();
            for (int i : combi) {
                char alphabet = chars[i];
                if(alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u') count++;
                line.append(alphabet);
            }
            if(count >= 1 && count <= L -2){
                sb.append(line);
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < C; i++) {
            combi[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}
