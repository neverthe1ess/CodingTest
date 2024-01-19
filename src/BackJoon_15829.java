import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon_15829 {
    public static void main(String[] args) throws IOException {
        long hash = 0;
        long pow = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stLength = Integer.parseInt(br.readLine());
        String st = br.readLine();

        for(int i = 0; i < stLength; i++){
            hash += (st.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(hash);
    }
}
