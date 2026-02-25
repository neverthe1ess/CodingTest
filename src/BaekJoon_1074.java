import java.util.Scanner;

public class BaekJoon_1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int result = gridCalculate(N, r, c);
        System.out.println(result);
    }
    private static int gridCalculate(int N, int r, int c){
        if(N == 0){
            return 0;
        }
        int partSize = 1 << (N - 1);
        int area = partSize * partSize;
        if (r < partSize) {
            if (c < partSize) {
                return gridCalculate(N - 1, r, c);
            }
            return area + gridCalculate(N - 1, r, c - partSize);
        }
        if (c < partSize) {
            return 2 * area + gridCalculate(N - 1, r - partSize, c);
        }
        return 3 * area + gridCalculate(N - 1, r - partSize, c - partSize);
    }
}
