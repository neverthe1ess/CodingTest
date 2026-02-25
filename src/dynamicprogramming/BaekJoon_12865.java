package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr.add(new int[]{W, V});
        }

    }

    private static int bag(ArrayList<int[]> arr, int K){
        int result = 0;
        if (K < 0){
            return 0;
        }
        for (int i = 0; i < arr.size() ; i++) {
            int newW = K - (arr.get(i)[0]);
            System.out.println(newW);
            result = Math.max(result, arr.get(i)[1] + bag(arr, newW));
        }
        return result;
    }
}
