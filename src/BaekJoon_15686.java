import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon_15686 {
    static class House {
        int x, y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static final int house = 1;
    private static final int chicken = 2;
    private static int M, chickenCount;
    private static int[] arr;
    private static int min;
    private static List<House> houseList, chickenList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        chickenCount = 0;
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                int area = Integer.parseInt(st.nextToken());
                if(area == house){
                    houseList.add(new House(j, i));
                } else if(area == chicken){
                    chickenList.add(new House(j, i));
                    chickenCount++;
                }
            }
        }
        arr = new int[M];
        dfs(0, 1);
        System.out.println(min);

    }
    private static void dfs(int depth, int start){
        if(depth == M){
            minCalculate();
            return;
        }
        for (int i = start; i <= chickenCount; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }

    }
    private static void minCalculate(){
        int cityChickenDistance = 0;
        for (House house : houseList) {
            int houseChickenDistance = Integer.MAX_VALUE;
            for (int i : arr) {
                House targetChicken = chickenList.get(i - 1);
                int distance = Math.abs(house.x - targetChicken.x)
                        + Math.abs(house.y - targetChicken.y);
                houseChickenDistance = Math.min(houseChickenDistance, distance);
            }
            cityChickenDistance += houseChickenDistance;
        }
        min = Math.min(min, cityChickenDistance);
    }
}
