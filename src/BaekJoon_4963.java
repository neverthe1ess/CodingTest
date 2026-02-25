import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_4963 {
    public static int[][] map;
    public static boolean[][] isVisited;
    public static int w, h;
    //상하좌우
    public static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            int count = 0;

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            map = new int[h][w];
            isVisited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!isVisited[i][j] && map[i][j] == 1){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        isVisited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if(nowX >= 0 && nowY >=0 && nowX < h && nowY < w){
                if(map[nowX][nowY] == 1 && !isVisited[nowX][nowY]){
                    dfs(nowX, nowY);
                }
            }
        }
    }
}
