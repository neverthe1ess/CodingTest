import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2146 {
    static class Node{
        int row, col, isLandNumber;

        public Node(int row, int col, int isLandNumber) {
            this.row = row;
            this.col = col;
            this.isLandNumber = isLandNumber;
        }
    }
    private static int[][] map, separatedMap;
    private static int[][] dist;
    private static int N;
    private static int[] dRows = {1, -1, 0, 0};
    private static int[] dCols = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        separatedMap = new int[N][N];
        for (int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int isLandNumber = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1 && dist[i][j] == 0){
                    isLandNumber++;
                    isLandSearch(i, j, isLandNumber);
                }
            }
        }
        Queue<Node> queue = new ArrayDeque<>();
        int[][] areaNumbers = new int[N][N];
        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                if(separatedMap[i][j] >= 1){
                    dist[i][j] = 0;
                    areaNumbers[i][j] = separatedMap[i][j];
                    queue.add(new Node(i, j, separatedMap[i][j]));
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRows = cur.row + dRows[i];
                int nCols = cur.col + dCols[i];

                if(nRows < 0 || nCols < 0 || nRows >= N || nCols >= N) continue;
                if(dist[nRows][nCols] == -1){
                    dist[nRows][nCols] = dist[cur.row][cur.col] + 1;
                    areaNumbers[nRows][nCols] = cur.isLandNumber;
                    queue.add(new Node(nRows, nCols, cur.isLandNumber));
                } else if(areaNumbers[nRows][nCols] != cur.isLandNumber){
                    answer = Math.min(answer, dist[cur.row][cur.col] + dist[nRows][nCols]);
                }
            }
        }
        System.out.println(answer);
    }
    private static void isLandSearch(int row, int col, int isLandNumber){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, isLandNumber));
        dist[row][col] = 1;
        separatedMap[row][col] = isLandNumber;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dRows[i];
                int nCol = cur.col + dCols[i];

                if(nRow < 0 || nCol < 0 || nRow >= N || nCol >= N) continue;
                if(map[nRow][nCol] == 1 && dist[nRow][nCol] == 0){
                    dist[nRow][nCol] = dist[cur.row][cur.col] + 1;
                    separatedMap[nRow][nCol] = isLandNumber;
                    queue.add(new Node(nRow, nCol, isLandNumber));
                }
            }
        }
    }
}
