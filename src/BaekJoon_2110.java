import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_2110 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(search(C, 1, arr[N - 1] - arr[0], 0));
    }
    private static int search(int count, int left, int right, int answer){
        if(left > right) return answer;

        int mid = (left + right) / 2;
        if(count(mid) >= count){
            return search(count, mid + 1, right, mid);
        } else {
            return search(count,  left, mid - 1, answer);
        }
    }
    private static int count(int thresholdDistance){
        int count = 1;
        int lastInstalled = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - lastInstalled >= thresholdDistance){
                count++;
                lastInstalled = arr[i];
            }
        }
        return count;
    }
}
