import java.io.BufferedReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer dist, price;
        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N];
        long[] oilPrice = new long[N];

        dist = new StringTokenizer(br.readLine());
        long distSum = 0;

        for(int i = 0; i < N - 1; i++){
            long temp = Long.parseLong(dist.nextToken());
            distance[i] = temp;
            distSum += temp;
        }

        price = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            oilPrice[i] = Integer.parseInt(price.nextToken());
        }

        long min = Long.MAX_VALUE;
        long result = 0;

        for(int i = 0; i < N; i++){
            min = Math.min(min, oilPrice[i]);

            result += (min * distance[i]);
        }
        System.out.println(result);

    }
}
