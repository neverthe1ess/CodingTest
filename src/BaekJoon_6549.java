import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_6549 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneline;
        StringTokenizer st;
        while(!(oneline = br.readLine()).equals("0")){
            st = new StringTokenizer(oneline);
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(getAreaSize(0, n - 1));
        }
    }
    private static long getAreaSize(int start, int end){
        if(start == end) return arr[start];

        int mid = (start + end) / 2;

        long leftAreaSize = getAreaSize(start, mid);
        long rightAreaSize = getAreaSize(mid + 1, end);
        long maxAreaSize = Math.max(leftAreaSize, rightAreaSize);

        maxAreaSize = Math.max(maxAreaSize, getMidAreaSize(start, end, mid));
        return maxAreaSize;
    }
    private static long getMidAreaSize(int start, int end, int mid){
        int pStart, pEnd;
        pStart = pEnd = mid;
        int minHeight = arr[mid];
        long maxAreaSize = minHeight;

        while(start < pStart && pEnd < end){
            if(arr[pStart - 1] < arr[pEnd + 1]){
                pEnd++;
                minHeight = Math.min(minHeight, arr[pEnd]);
                maxAreaSize = Math.max(maxAreaSize, (long)minHeight * (pEnd - pStart + 1));
            } else {
                pStart--;
                minHeight = Math.min(minHeight, arr[pStart]);
                maxAreaSize = Math.max(maxAreaSize, (long)minHeight * (pEnd - pStart + 1));
            }
        }

        while(pEnd < end){
            pEnd++;
            minHeight = Math.min(minHeight, arr[pEnd]);
            maxAreaSize = Math.max(maxAreaSize, (long)minHeight * (pEnd - pStart + 1));
        }

        while(start < pStart){
            pStart--;
            minHeight = Math.min(minHeight, arr[pStart]);
            maxAreaSize = Math.max(maxAreaSize, (long)minHeight * (pEnd - pStart + 1));
        }

        return maxAreaSize;
    }
}
