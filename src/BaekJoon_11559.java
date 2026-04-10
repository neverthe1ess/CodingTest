import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BaekJoon_11559 {
    public static final int line = 12;
    private static char[][] map;
    private static boolean[][] isVisited;
    private static int[] dRow = {1, -1, 0, 0};
    private static int[] dCol = {0, 0, -1, 1};
    private static final int ch = 6;

    static class Node {
        int row, col, color;

        public Node(int row, int col, int color) {
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[line][ch];
        for (int i = 0; i < line; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int count = 0;
        while(true){
            isVisited = new boolean[line][ch];
            List<Node> deleteNodes = new ArrayList<>();

            for (int i = 0; i < line ; i++) {
                for (int j = 0; j < ch; j++) {
                    if(map[i][j] != '.' && !isVisited[i][j]){
                        List<Node> nodeList = bfs(i, j, map[i][j]);
                        if(nodeList != null){
                            deleteNodes.addAll(nodeList);
                        }
                    }
                }
            }

            if(deleteNodes.isEmpty()){
                break;
            }

            for (Node deleteNode : deleteNodes) {
                int row = deleteNode.row;
                int col = deleteNode.col;
                map[row][col] = 0;
            }

            for (int i = 0; i < ch; i++) {
                List<Character> charList = new ArrayList<>();
                for (int j = 0; j < line ; j++) {
                    if(map[j][i] != '.' && map[j][i] != 0){
                        charList.add(map[j][i]);
                    }
                }
                for (int j = 0; j < line; j++) {
                    if(j < line - charList.size()){
                        map[j][i] = '.';
                    } else {
                        map[j][i] = charList.get(j - (line - charList.size()));
                    }
                }
            }
            count++;
        }
        System.out.println(count);
    }
    private static List<Node> bfs(int row, int col, int color){
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> deleteList = new ArrayList<>();
        queue.add(new Node(row, col, color));
        isVisited[row][col] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            deleteList.add(new Node(cur.row, cur.col, cur.color));

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + dRow[i];
                int nCol = cur.col + dCol[i];

                if(nRow < 0 || nCol < 0 || nRow >= line || nCol >= ch) continue;
                if(map[nRow][nCol] == cur.color && !isVisited[nRow][nCol]){
                    queue.add(new Node(nRow, nCol, cur.color));
                    isVisited[nRow][nCol] = true;
                }
            }
        }

        if(deleteList.size() >= 4){
            return deleteList;
        } else {
            return null;
        }
    }
}
