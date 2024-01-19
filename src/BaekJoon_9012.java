import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String a = br.readLine();
            sb.append(checkStack(a) +"\n");
        }
        System.out.println(sb);
    }

    public static String checkStack(String a){

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if(!stack.empty()){
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        if(stack.empty()){
            return "YES";
        } else {
            return "NO";
        }
    }
}
