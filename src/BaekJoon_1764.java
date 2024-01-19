import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String count = br.readLine();
        StringTokenizer st = new StringTokenizer(count);
        int notHear = Integer.parseInt(st.nextToken());
        int notLook = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < notHear; i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>();

        for(int i = 0; i < notLook; i++){
            String a = br.readLine();
            if(set.contains(a)){
                list.add(a);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
