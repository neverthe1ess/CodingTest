import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_5014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);
        int[] dStairs = {U, D * -1};

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(S);
        dist[S] = 0;
        if(S == G){
            System.out.println(0);
            return;
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nStairs = cur + dStairs[i];
                if(nStairs <= 0 || nStairs > F) continue;
                if(dist[nStairs] < 0){
                    dist[nStairs] = dist[cur] + 1;
                    if(nStairs == G) {
                        System.out.println(dist[nStairs]);
                        return;
                    }
                    queue.add(nStairs);
                }
            }
        }
        System.out.println("use the stairs");

    }
}
