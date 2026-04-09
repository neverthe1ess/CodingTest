import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_15683_2 {
    static class CCTV{
        int row, col, category;

        public CCTV(int row, int col, int category) {
            this.row = row;
            this.col = col;
            this.category = category;
        }
    }
    private static int[] dRows = {1, 0, -1, 0};
    private static int[] dCols = {0, 1, 0, -1};
    private static List<CCTV> cctvList;
    private static int[][][] directions;
    private static int N, M, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        int[][] map = new int[N][M];
        cctvList = new ArrayList<>();
        directions = new int[6][][];
        directions[1] = new int[][] {{0}, {1}, {2}, {3}};
        directions[2] = new int[][] {{0, 2}, {1,3}};
        directions[3] = new int[][] {{0, 1},{1, 2},{2, 3},{3, 0}};
        directions[4] = new int[][] {{3, 0, 1}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}};
        directions[5] = new int[][] {{0, 1, 2, 3}};

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
            min = Integer.min(min, count);
            return;
        }
        CCTV targetCctv = cctvList.get(depth);
        for (int[] direction : directions[targetCctv.category]) {
            int[][] newMap = mapCopy(map);
            mark(targetCctv.row, targetCctv.col, direction, newMap);
            dfs(depth + 1, newMap);
        }
    }
    private static int[][] mapCopy(int[][] targetMap){
        int[][] reMap = new int[N][M];
        for (int i = 0; i <targetMap.length ; i++) {
            System.arraycopy(targetMap[i], 0, reMap[i], 0, M);
        }
        return reMap;
    }
    private static void mark(int x, int y, int[] dir, int[][] map){
        for (int i : dir) {
            int nRow = x;
            int nCol = y;

            while(true){
                nRow += dRows[i];
                nCol += dCols[i];

                if(nCol < 0 || nRow < 0 || nRow >= N || nCol >= M) break;
                if(map[nRow][nCol] == 6) break;
                if(map[nRow][nCol] == 0 ){
                    map[nRow][nCol] = '#';
                }
            }
        }
    }
}
