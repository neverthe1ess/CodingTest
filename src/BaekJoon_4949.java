import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String abc = br.readLine();
            if(abc.equals(".")) break;
            sb.append(checkStack(abc) + '\n');
        }
        System.out.println(sb);
    }

    public static String checkStack(String abc) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < abc.length(); i++) {
            char ch = abc.charAt(i);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            } else if (ch == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.empty()){
            return "yes";
        } else {
            return "no";
        }
    }
}
