import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> stringSet = new HashSet<>();
        while(N-- > 0){
            stringSet.add(br.readLine());
        }
        List<String> stringList = new ArrayList<>(stringSet);
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = o1.length() - o2.length();
                if(result == 0){
                    result = o1.compareTo(o2);
                }
                return result;
            }
        });
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
