import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_2583 {
    private static int[][] maze;
    private static int M, N;
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1};
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        maze = new int[M][N];

        for (int i = 0; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for (int j = startY; j < endY ; j++) {
                for (int k = startX ; k <endX ; k++) {
                    maze[j][k] = -1;
                }
            }
        }
        int regionCount = 0;
        int regionArea = 0;
        List<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < M ; i++) {
            for (int j = 0; j < N; j++) {
                if(maze[i][j] == 0){
                    regionArea = bfs(i, j);
                    areaList.add(regionArea);
                    regionCount++;
                }
            }
        }
        Collections.sort(areaList);
        System.out.println(regionCount);
        for (Integer i : areaList) {
            System.out.print(i + " ");
        }

    }
    private static int bfs(int row, int col){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col));
        maze[row][col] = 1;
        int area = 0;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            area++;

            for (int i = 0; i < 4 ; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= M || nCol >= N) continue;
                if(maze[nRow][nCol] == 0){
                    maze[nRow][nCol] = 1;
                    queue.add(new Node(nRow, nCol));
                }
            }
        }
        return area;
    }

}
