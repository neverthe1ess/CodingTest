import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = N;


        for(int i = 0; i < N; i++){
            String word = br.readLine();
            boolean[] group = new boolean[26];
            if(word.length() == 1) continue; //길이가 1일때 무조건 그룹단어
            group[word.charAt(0) - 'a'] = true;
            for(int j = 1; j < word.length(); j++){ // 그 외의 경우
                int pre = word.charAt(j - 1) - 'a';
                int now = word.charAt(j) - 'a'; // 0 ~ 25
                if(group[now] == true && pre != now){
                    count--;
                    break;
                }
                group[now] = true;
            }
        }
        System.out.println(count);
    }
}
