import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int length = Integer.parseInt(br.readLine());
            list[i] = length;
            sum += length;
        }
        int threshold = sum - 100;
        int removeI = -1;
        int removeJ = -1;

        outer:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (threshold == list[i] + list[j]) {
                    removeI = i;
                    removeJ = j;
                    break outer;
                }
            }
        }

        list[removeI] = -1;
        list[removeJ] = -1;

        Arrays.sort(list);
        for (int i : list) {
            if (i != -1) {
                System.out.println(i);
            }
        }


    }
}
