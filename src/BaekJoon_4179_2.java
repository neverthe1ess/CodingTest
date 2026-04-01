import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_4179_2 {
    static class Node {
        int rows, cols;

        public Node(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dRows = {1, -1, 0, 0};
        int[] dCols = {0, 0, -1, 1};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] maze = new char[R][C];
        int[][] disFire = new int[R][C];
        int[][] disJihoon = new int[R][C];

        for (int i = 0; i < disFire.length ; i++) {
            Arrays.fill(disFire[i], -1);
            Arrays.fill(disJihoon[i], -1);
        }
        Queue<Node> qFire = new ArrayDeque<>();
        Queue<Node> qJihoon = new ArrayDeque<>();

        for (int i = 0; i < R ; i++) {
            char[] chars = br.readLine().toCharArray();
            System.arraycopy(chars, 0, maze[i], 0, C);
            for (int j = 0; j < C ; j++) {
                if(chars[j] == 'J') {
                    disJihoon[i][j] = 0;
                    qJihoon.add(new Node(i, j));
                }

                if(chars[j] == 'F'){
                    disFire[i][j] = 0;
                    qFire.add(new Node(i, j));
                }
            }
        }

        while(!qFire.isEmpty()){
            Node cur = qFire.poll();

            for (int i = 0; i < 4 ; i++) {
                int nRow = cur.rows + dRows[i];
                int nCol = cur.cols + dCols[i];

                if(nRow < 0 || nCol < 0 || nRow >= R || nCol >= C) continue;
                if(maze[nRow][nCol] != '#' && disFire[nRow][nCol] == -1){
                    disFire[nRow][nCol] = disFire[cur.rows][cur.cols] + 1;
                    qFire.add(new Node(nRow, nCol));
                }
            }
        }

        while(!qJihoon.isEmpty()){
            Node cur = qJihoon.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = cur.rows + dRows[i];
                int nCol = cur.cols + dCols[i];
                if(nRow < 0 || nCol < 0 || nRow >= R || nCol >= C){
                    System.out.println(disJihoon[cur.rows][cur.cols] + 1);
                    return;
                }

                if(maze[nRow][nCol] == '#' || disJihoon[nRow][nCol] >= 0) continue;
                if(disFire[nRow][nCol] == -1 ||  disJihoon[cur.rows][cur.cols] + 1 < disFire[nRow][nCol]){
                    disJihoon[nRow][nCol] = disJihoon[cur.rows][cur.cols] + 1;
                    qJihoon.add(new Node(nRow, nCol));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
