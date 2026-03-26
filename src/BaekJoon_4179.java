import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_4179 {
    private static int[] dRows = {0, 0, -1, 1};
    private static int[] dCols = {1, -1, 0, 0};
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] maze = new char[R][C];
        int[][] disJihoon = new int[R][C];
        int[][] disFire = new int[R][C];

        for (int i = 0; i < disFire.length ; i++) {
            Arrays.fill(disFire[i], -1);
            Arrays.fill(disJihoon[i], -1);
        }

        for (int i = 0; i < R; i++) {
            char[] row= br.readLine().toCharArray();
            System.arraycopy(row, 0, maze[i], 0, C);
        }
        Queue<Node> qFire = new ArrayDeque<>();
        Queue<Node> qJihoon = new ArrayDeque<>();

        for (int i = 0; i < R ; i++) {
            for (int j = 0; j < C ; j++) {
                if(maze[i][j] == 'F') {
                    qFire.add(new Node(i, j));
                    disFire[i][j] = 0;
                }
                if(maze[i][j] == 'J') {
                    qJihoon.add(new Node(i, j));
                    disJihoon[i][j] = 0;
                }
            }
        }
        while(!qFire.isEmpty()){
            Node cur = qFire.poll();
            for (int i = 0; i < 4 ; i++) {
                int newRow = cur.row + dRows[i];
                int newCol = cur.col + dCols[i];

                if(newRow < 0 || newCol < 0 || newCol >= C || newRow >= R) continue;
                if(maze[newRow][newCol] != '#' && disFire[newRow][newCol] < 0){
                    disFire[newRow][newCol] = disFire[cur.row][cur.col] + 1;
                    qFire.add(new Node(newRow, newCol));
                }
            }
        }

        while(!qJihoon.isEmpty()){
            Node cur = qJihoon.poll();
            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + dRows[i];
                int newCol = cur.col + dCols[i];

                if(newRow < 0 || newCol < 0 || newRow >= R || newCol >= C){
                    System.out.println(disJihoon[cur.row][cur.col] + 1);
                    return;
                }
                if(maze[newRow][newCol] == '#' || disJihoon[newRow][newCol] >= 0) continue;
                if(disFire[newRow][newCol] != -1 && disJihoon[cur.row][cur.col] + 1 >=  disFire[newRow][newCol]) continue;
                disJihoon[newRow][newCol] = disJihoon[cur.row][cur.col] + 1;
                qJihoon.add(new Node(newRow, newCol));
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
