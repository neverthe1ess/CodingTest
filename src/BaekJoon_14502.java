import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_14502 {

    private static int n, m;
    private static int maxSafeAreaCount = Integer.MIN_VALUE;
    private static int[][] map;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(maxSafeAreaCount);
    }
    public static void buildWall(int wall){
        if(wall == 3){
            countSafeArea();
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    buildWall(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void countSafeArea(){
        int[][] copyMap = new int[n][m];
        for(int i = 0; i < n; i++){
            copyMap[i] = Arrays.copyOf(map[i], m);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyMap[i][j] == 2){
                    bfs(copyMap, i, j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        maxSafeAreaCount = Math.max(maxSafeAreaCount, cnt);
    }
    public static void bfs(int[][] copyMap, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = now[0] + dx[i];
                int newY = now[1] + dy[i];

                if(validAreaCheck(newX, newY) && copyMap[newX][newY] == 0){
                    copyMap[newX][newY] = 2;
                    queue.add(new int[] {newX, newY});
                }
            }
        }
    }

    public static boolean validAreaCheck(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
