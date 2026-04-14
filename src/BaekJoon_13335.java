import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> bridge = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int curCapacity = L;
        int[] truckList = new int[n];
        for (int i = 0; i < w ; i++) {
            bridge.offer(0);
        }

        int curP = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truckList[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0;
        while(curP < n){
            time++;
            int truck = bridge.poll();
            curCapacity += truck;
            if(truckList[curP] <= curCapacity){
                bridge.offer(truckList[curP]);
                curCapacity-= truckList[curP];
                curP++;
            } else {
                bridge.offer(0);
            }
        }
        System.out.println(time + w);
    }
}
