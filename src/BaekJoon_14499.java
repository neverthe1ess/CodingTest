import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_14499 {
    private static int[]  dice, instructions;
    private static int[][] map;
    private static int[] dRow = {0, 0, 0, -1, 1};
    private static int[] dCol = {0, 1, -1, 0, 0};
    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;
    private static final int EAST = 4;
    private static final int WEST = 5;
    private static int k, N, M;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        dice = new int[6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        instructions = new int[k];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            instructions[i] = Integer.parseInt(st.nextToken());
        }
        action(0, x, y);
        System.out.println(sb);
    }
    private static void action(int depth, int row, int col){
        if(depth == k){
            return;
        }
        int operation = instructions[depth];
        int nRow = row + dRow[operation];
        int nCol = col + dCol[operation];
        if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= M){
            action( depth + 1, row, col);
            return;
        }

        roll(operation);

        if(map[nRow][nCol] == 0){
            map[nRow][nCol] = dice[BOTTOM];
        } else {
            dice[BOTTOM] = map[nRow][nCol];
            map[nRow][nCol] = 0;
        }

        sb.append(dice[TOP]).append("\n");
        action(depth + 1, nRow, nCol);
    }
    private static void roll(int op){
        int temp;
        switch (op){
            case 1 -> {
                temp = dice[TOP];
                dice[TOP] = dice[WEST];
                dice[WEST] = dice[BOTTOM];
                dice[BOTTOM] = dice[EAST];
                dice[EAST] = temp;
            }
            case 2 -> {
                temp = dice[TOP];
                dice[TOP] = dice[EAST];
                dice[EAST] = dice[BOTTOM];
                dice[BOTTOM] = dice[WEST];
                dice[WEST] = temp;
            }
            case 3 -> {
                temp = dice[TOP];
                dice[TOP] = dice[SOUTH];
                dice[SOUTH] = dice[BOTTOM];
                dice[BOTTOM] = dice[NORTH];
                dice[NORTH] = temp;
            }
            case 4 -> {
                temp = dice[TOP];
                dice[TOP] = dice[NORTH];
                dice[NORTH] = dice[BOTTOM];
                dice[BOTTOM] = dice[SOUTH];
                dice[SOUTH] = temp;
            }
        }
    }
}
