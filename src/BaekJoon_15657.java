import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_15657 {
    private static int M;
    private static int[] arr;
    private static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        arr = new int[M];
        dfs(0, list.getFirst());


    }
    private static void dfs(int depth, int start){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = 0; i < list.size() ; i++) {
            int element = list.get(i);
            if(element < start) continue;
            arr[depth] = element;
            dfs(depth + 1, element);
        }
    }
}
