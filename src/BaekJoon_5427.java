import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_5427 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private static int w, h;
    public static void main(String[] args) throws IOException {
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Node> queueFire = new ArrayDeque<>();
            Queue<Node> queueSangGeun = new ArrayDeque<>();
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            char[][] buildingMap = new char[h][w];
            int[][] distSangGeun = new int[h][w];
            int[][] distFire = new int[h][w];
            for (int i = 0; i < distFire.length; i++) {
                Arrays.fill(distFire[i], -1);
                Arrays.fill(distSangGeun[i], -1);
            }
            
            for (int i = 0; i < h; i++) {
                String oneLine = br.readLine();
                for (int j = 0; j < w ; j++) {
                    buildingMap[i][j] = oneLine.charAt(j);
                    if(buildingMap[i][j] == '*'){
                        queueFire.add(new Node(i, j));
                        distFire[i][j] = 0;
                    }
                    
                    if(buildingMap[i][j] == '@'){
                        queueSangGeun.add(new Node(i, j));
                        distSangGeun[i][j] = 0;
                    }
                }
            }
            
            while(!queueFire.isEmpty()){
                Node cur = queueFire.poll();

                for (int i = 0; i < 4; i++) {
                    int nRow = cur.row + dRow[i];
                    int nCol = cur.col + dCol[i];

                    if(nCol < 0 || nRow < 0 || nCol >= w || nRow >= h) continue;
                    if(buildingMap[nRow][nCol] != '#' && distFire[nRow][nCol] < 0){
                        distFire[nRow][nCol] = distFire[cur.row][cur.col] + 1;
                        queueFire.add(new Node(nRow, nCol));
                    }
                }
            }
            boolean isFind = false;

            while(!queueSangGeun.isEmpty()){
                Node cur = queueSangGeun.poll();

                for (int i = 0; i < 4 ; i++) {
                    int nRow = cur.row + dRow[i];
                    int nCol = cur.col + dCol[i];

                    if(nCol < 0 || nRow < 0 || nCol >= w || nRow >= h) {
                        System.out.println(distSangGeun[cur.row][cur.col] + 1);
                        isFind = true;
                        break;
                    }
                    if(buildingMap[nRow][nCol] != '#' && (distSangGeun[cur.row][cur.col] + 1 < distFire[nRow][nCol] || distFire[nRow][nCol] == -1) && distSangGeun[nRow][nCol] == -1){
                        distSangGeun[nRow][nCol] = distSangGeun[cur.row][cur.col] + 1;
                        queueSangGeun.add(new Node(nRow, nCol));
                    }
                }
                if(isFind) {
                    break;
                }
            }
            if(!isFind){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
