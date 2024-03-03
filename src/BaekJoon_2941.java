import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        int count = 0;

        for(int i = 0; i < words.length(); i++){
            char now = words.charAt(i);
            char next = '0';
            if(i < words.length() - 1)  {
                next = words.charAt(i + 1);
            }


            if(now == 'c') {
                if(next == '=' || next == '-'){
                    i++;
                }
            }

            else if(now == 'd') {
                if(next == '-'){
                    i++;
                } else if (next == 'z' && i < words.length() - 2){
                    if(words.charAt(i + 2) == '='){
                        i += 2;
                    }
                }
            }

            else if(now == 'l') {
                if(next == 'j'){
                    i++;
                }
            }

            else if(now == 'n') {
                if(next == 'j'){
                    i++;
                }
            }

            else if(now == 's') {
                if(next == '='){
                    i++;
                }
            }

            else if(now == 'z') {
                if(next == '='){
                    i++;
                }
            }
            count++;
        }

        System.out.println(count);



    }
}
