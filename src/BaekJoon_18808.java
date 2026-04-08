import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_18808 {
    private static int N, M, K;
    private static int[][][] stickers;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stickers = new int[K][][];
        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            stickers[i] = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    stickers[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int i = 0; i < K; i++) {
            int[][] sticker = stickers[i];
            for (int j = 0; j < 4; j++) {
                if(canAttach(sticker)){
                    break;
                }
                sticker = rotate(sticker);
            }
        }
        int count = 0;
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) count++;
            }
        }
        System.out.println(count);

    }
    private static boolean canAttach(int[][] sticker){
        int R = sticker.length;
        int C = sticker[0].length;
        
        boolean canAttach = false;
        for (int i = 0; i < N - R + 1 ; i++) {
            for (int j = 0; j < M - C + 1; j++) {
                canAttach = true;
                for (int k = 0; k < R ; k++) {
                    for (int l = 0; l < C; l++) {
                        if(sticker[k][l] == 1 && map[i + k][j + l] == 1){
                            canAttach = false;
                        }
                    }
                }
                if(canAttach){
                    for (int k = 0; k < R; k++) {
                        for (int l = 0; l < C; l++) {
                            if(sticker[k][l] == 1){
                                map[i + k][j + l] = 1;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] rotate(int[][] sticker){
        int r = sticker.length;
        int c = sticker[0].length;
        
        int[][] rotated = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r ; j++) {
                rotated[i][j] = sticker[r - 1 - j][i];
            }
        }
        return rotated;
    }
}
