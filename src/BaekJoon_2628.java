import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> horizontalLengths = new ArrayList<Integer>();
        List<Integer> verticalLengths = new ArrayList<Integer>();
        
        int W = sc.nextInt();
        int H = sc.nextInt();
        horizontalLengths.add(0);
        horizontalLengths.add(H);
        verticalLengths.add(0);
        verticalLengths.add(W);
        int count = sc.nextInt();
        while (count-- > 0) {
            int method = sc.nextInt();
            int number = sc.nextInt();
            if (method == 0) {
                horizontalLengths.add(number);
            } else {
                verticalLengths.add(number);
            }
        }

        horizontalLengths.sort(Integer::compareTo);
        verticalLengths.sort(Integer::compareTo);

        int maxW = 0;
        for (int i = 1; i < horizontalLengths.size(); i++) {
            maxW = Math.max(maxW, horizontalLengths.get(i) - horizontalLengths.get(i - 1));
        }
        int maxH = 0;
        for (int i = 1; i < verticalLengths.size(); i++) {
            maxH = Math.max(maxH, verticalLengths.get(i) - verticalLengths.get(i - 1));
        }
        System.out.println(maxW * maxH);
    }
}
