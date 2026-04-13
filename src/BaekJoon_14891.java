import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_14891 {
    private static int[][] gears;
    private static final int clockwise = 1;
    private static final int counterClockwise = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gears = new int[6][9];
        for (int i = 1; i <= 4; i++) {
            String gear = br.readLine();
            for (int j = 0; j < 8 ; j++) {
                gears[i][j] = gear.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            action(target, dir, -3);
        }

        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if(gears[i][0] == 1){
                sum +=(int)Math.pow(2, i - 1);
            }
        }
        System.out.println(sum);

    }
    private static void action(int targetNumber, int direction, int prev){
        if(targetNumber <= 0 || targetNumber >= 5){
            return;
        }

        int targetDirection = (direction == counterClockwise) ? clockwise : counterClockwise;
        int[] targetGear = gears[targetNumber];
        int[] targetLeftGear = gears[targetNumber - 1];
        int[] targetRightGear = gears[targetNumber + 1];

        if(targetGear[6] != targetLeftGear[2] && prev != targetNumber - 1){
            action(targetNumber - 1, targetDirection,  targetNumber);
        }
        if(targetGear[2] != targetRightGear[6] && prev != targetNumber + 1){
            action(targetNumber + 1, targetDirection, targetNumber);
        }

        rotation(targetNumber, direction);

    }



    private static void rotation(int targetNumber, int direction){
        int[] targetGear = gears[targetNumber];
        if(direction == counterClockwise){
            int tempStart = targetGear[0];
            for (int i = 1; i <= 7 ; i++) {
                targetGear[i - 1] = targetGear[i];
            }
            targetGear[7] = tempStart;
        } else {
            int tempStart = targetGear[7];
            for (int i = 6; i >= 0 ; i--) {
                targetGear[i + 1] = targetGear[i];
            }
            targetGear[0] = tempStart;
        }
    }
}
