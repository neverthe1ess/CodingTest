import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_12100 {
    private static int N, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        int[][] map = new int[N][N];

        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, map);
        System.out.println(max);
    }
    private static void dfs(int depth, int[][] map){
        if(depth == 5){
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] movedMap = moveMap(i, map);
            dfs(depth + 1, movedMap);
        }
    }
    private static int[][] moveMap(int direction, int[][] oldMap){
        int[][] newMap = new int[N][N];

        for (int i = 0; i < oldMap.length ; i++) {
            System.arraycopy(oldMap[i], 0, newMap[i], 0, N);
        }
        for (int i = 0; i < direction ; i++) {
            newMap = rotate(newMap);
        }

        newMap = moveUP(newMap);

        for (int i = 0; i < (4 - direction); i++) {
            newMap = rotate(newMap);
        }

        return newMap;
    }
    private static int[][] rotate(int[][] map){
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                rotated[j][N - 1 - i] = map[i][j];
            }
        }
        return rotated;
    }

    private static int[][] moveUP(int[][] newMap) {
        boolean[][] isCompressed = new boolean[N][N];
        for (int col = 0; col < N; col++) {
            int idx = 0;
            for (int row = 0; row <N; row++) {
                if(newMap[row][col] == 0) continue;
                if(idx > 0 && newMap[idx - 1][col] == newMap[row][col] && !isCompressed[idx - 1][col]){
                    newMap[idx - 1][col] += newMap[row][col];
                    isCompressed[idx - 1][col] = true;
                    newMap[row][col] = 0;
                } else {
                    if(idx != row){
                        newMap[idx][col] = newMap[row][col];
                        newMap[row][col] = 0;
                    }
                    idx++;
                }
            }
        }
        return newMap;
    }
}
