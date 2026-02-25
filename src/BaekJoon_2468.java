import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2468 {

    public static int[][] map;
    public static boolean[][] isVisited;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        for(int i = 1; i <= 100; i++){
            int count = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if(map[j][k] > i && !isVisited[j][k]){
                        bfs(j, k);
                        count++;
                    }
                }
            }
            if(max < count) max = count;
        }
    }

    public static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);



    }
}
