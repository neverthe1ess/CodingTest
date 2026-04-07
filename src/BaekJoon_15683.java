import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_15683 {
    static class CCTV{
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    private static int M, N;
    private static int[] dRows = {1, 0, -1, 0};
    private static int[] dCols = {0, 1, 0, -1};
    private static List<CCTV> cctvList;
    private static List<int[][]>[] directionList;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        directionList = new List[6];
        cctvList = new ArrayList<>();
        for (int i = 0; i <= 5 ; i++) {
            directionList[i] = new ArrayList<>();
        }
        directionList[1].add(new int[][]{{0}, {1}, {2}, {3}});
        directionList[2].add(new int[][] {{0, 2}, {1, 3}});
        directionList[3].add(new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 0}});
        directionList[4].add(new int[][] {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}});
        directionList[5].add(new int[][] {{0, 1, 2, 3}});


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= map[i][j] && map[i][j] <= 5){
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }
        dfs(0, map);
        System.out.println(min);

    }
    private static void dfs(int depth, int[][] map){
        if(depth == cctvList.size()){
            int count = 0;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) count++;
                }
            }
            min = Math.min(min, count);
            return;
        }
        CCTV cctv = cctvList.get(depth);
        for (int[][] direction : directionList[cctv.type]) {
            for (int[] dir : direction) {
                int[][] newMap = new int[N][M];
                for (int i = 0; i < map.length; i++) {
                    System.arraycopy(map[i], 0, newMap[i], 0, M);
                }
                mark(cctv.x, cctv.y, newMap, dir);
                dfs(depth + 1,  newMap);
            }
        }
    }

    private static void mark(int x, int y, int[][] map, int[] dir){
        for (int i : dir) {
            int newRow = x;
            int newCol = y;

            while(true){
                newRow += dRows[i];
                newCol += dCols[i];

                if(newRow < 0 || newCol < 0 || newRow >= N || newCol >= M ) break;
                if(map[newRow][newCol] == 6) break;
                if(map[newRow][newCol] == 0){
                    map[newRow][newCol] = '#';
                }
            }
        }
    }
}
