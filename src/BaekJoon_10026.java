import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BaekJoon_10026 {
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1};
    private static char[][] grid, gridColorWeakness;
    private static boolean[][] isVisited;
    private static int N;
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        gridColorWeakness = new char[N][N];
        isVisited = new boolean[N][N];


        for (int i = 0; i < N ; i++) {
            char[] chars = br.readLine().toCharArray();
            System.arraycopy(chars, 0, grid[i], 0, N);
            for (int j = 0; j < N ; j++) {
                if(chars[j] == 'G') chars[j] = 'R';
                gridColorWeakness[i][j] = chars[j];
            }
        }

        int AreaCount = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(!isVisited[i][j]) {
                    bfs(i, j, false);
                    AreaCount++;
                }
            }
        }
        isVisited = new boolean[N][N];


        int WeaknessAreaCount = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N ; j++) {
                if(!isVisited[i][j]) {
                    bfs(i, j, true);
                    WeaknessAreaCount++;
                }
            }
        }
        System.out.println(AreaCount + " " + WeaknessAreaCount);
    }
    private static void bfs(int row, int col, boolean isColorWeakness){
        Queue<Node> queue = new ArrayDeque<>();
        char[][] targetGrid = isColorWeakness ?  gridColorWeakness : grid;
        char targetColor = targetGrid[row][col];
        isVisited[row][col] = true;
        queue.add(new Node(row, col));

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= N) continue;
                if(!isVisited[nRow][nCol] && targetGrid[nRow][nCol] == targetColor){
                    queue.add(new Node(nRow, nCol));
                    isVisited[nRow][nCol] = true;
                }
            }
        }


    }
}
