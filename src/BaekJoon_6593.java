import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_6593 {
    static class Node {
        int page, row, col;

        public Node(int page, int row, int col) {
            this.page = page;
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        int[] dPage = {0, 0, 0, 0, 1, -1};
        int[] dRow = {1, -1, 0, 0, 0, 0};
        int[] dCol = {0, 0, -1, 1, 0, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            Queue<Node> queue = new ArrayDeque<>();
            int[][][] building = new int[L][R][C];
            int targetL, targetR, targetC;
            targetL = targetR = targetC = 0;


            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R ; j++) {
                    char[] chars = br.readLine().toCharArray();
                    for (int k = 0; k < C ; k++) {
                        if(chars[k] == 'S'){
                           building[i][j][k] = 0;
                           queue.add(new Node(i, j, k));
                        } else if (chars[k] == '.'){
                            building[i][j][k] = -1;
                        } else if (chars[k] == '#') {
                            building[i][j][k] = -2;
                        } else {
                            building[i][j][k] = -1;
                            targetL = i;
                            targetR = j;
                            targetC = k;
                        }
                    }
                }
                br.readLine();
            }
            while(!queue.isEmpty()){
                Node cur = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nPage = cur.page + dPage[i];
                    int nRow = cur.row + dRow[i];
                    int nCol = cur.col + dCol[i];
                    if(nPage < 0 || nRow < 0 || nCol < 0 || nPage >= L || nRow >= R || nCol >= C) continue;
                    if(building[nPage][nRow][nCol] == -1){
                        building[nPage][nRow][nCol] = building[cur.page][cur.row][cur.col] + 1;
                        queue.add(new Node(nPage, nRow, nCol));
                    }
                }
            }
            int result = building[targetL][targetR][targetC];
            if(result < 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }
}
