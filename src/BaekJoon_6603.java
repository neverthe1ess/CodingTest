import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_6603 {
    private static int k;
    private static final int C = 6;
    private static int[] list, arr;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while(!(line = br.readLine()).equals("0")){
            sb = new StringBuilder();
            st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            arr = new int[C];
            list = new int[k];
            for (int i = 0; i < k; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println(sb);
        }
    }
    private static void dfs(int depth, int start){
        if(depth == C){
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            arr[depth] = list[i];
            dfs(depth + 1, i + 1);
        }
    }
}
