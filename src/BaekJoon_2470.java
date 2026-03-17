import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int value1 = 0;
        int value2 = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            int left = i + 1;
            int right = N - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                int sum = arr[i] + arr[mid];
                if(Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    value1 = arr[i];
                    value2 = arr[mid];
                }

                if(sum < 0){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if(left < N){
                int sum = arr[i] + arr[left];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    value1 = arr[i];
                    value2 = arr[left];
                }
            }

            if(right > i){
                int sum = arr[i] + arr[right];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    value1 = arr[i];
                    value2 = arr[right];
                }
            }
        }
        System.out.println(value1 + " " + value2);

    }
}
