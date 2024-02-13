import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2178 {

    public static int[][] maze;

    public static boolean[][] isVisited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    //up 0, 1
    //down 0, -1
    //left -1, 0
    //right 1, 0

    public static int N, M;

    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                if(line.charAt(j) - '0' == 1)
                    maze[i][j] = 1;
            }
        }
        isVisited = new boolean[N][M];
        isVisited[0][0] = true;
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);

    }

    public static void bfs(int x, int y){
        queue.add(new int[] {x, y});
        while (!queue.isEmpty()){
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M || isVisited[newX][newY] || maze[newX][newY] == 0){
                    continue;
                }
                queue.add(new int[] {newX, newY});
                maze[newX][newY] = maze[nowX][nowY] + 1;
                isVisited[newX][newY] = true;
            }
        }

    }
}
