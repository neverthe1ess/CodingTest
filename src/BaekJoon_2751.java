import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> integers = new ArrayList<Integer>();
        while(N-- > 0){
            integers.add(Integer.parseInt(br.readLine()));
        }
        integers.sort(null);
        for (int integer : integers) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
    }
}
