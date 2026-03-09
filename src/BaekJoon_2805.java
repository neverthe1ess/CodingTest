import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2805 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(search(M, 1, arr[N - 1], 0));
    }
    private static int search(long M, int left, int right, int answer){
        if(left > right) return answer;

        int mid = (left + right) / 2;

        if(calc(mid) >= M){
            return search(M, mid + 1, right, mid);
        } else {
            return search(M, left, mid - 1, answer);
        }
    }

    private static long calc(int threshold){
        long sum = 0;
        for (int i : arr) {
            if(i > threshold){
                sum += i - threshold;
            }
        }
        return sum;
    }
}
