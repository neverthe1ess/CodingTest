import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2630 {
    private static int[][] arr;
    private static int N;
    private static int whiteCount;
    private static int blueCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        whiteCount = blueCount = 0;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        search(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }
    private static void search(int startX, int startY, int size){
        if(size <= 0){
            return;
        }
        int pivot = arr[startY][startX];
        boolean allEqual = true;
        for (int i = startY; i < startY + size ; i++) {
            if(!allEqual) break;
            for (int j = startX; j < startX + size; j++) {
                if(arr[i][j] != pivot){
                    allEqual = false;
                    break;
                }
            }
        }

        if (allEqual){
            if(pivot == 0){
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            size = size / 2;
            search(startX, startY, size);
            search(startX + size, startY, size);
            search(startX, startY + size, size);
            search(startX + size, startY + size, size);
        }
    }
}
