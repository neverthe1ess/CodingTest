import java.util.Scanner;
import java.util.Stack;

public class BaekJoon_10799 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String steelBar = sc.nextLine();
        int count = 0;

        for (int i = 0; i < steelBar.length(); i++) {
            char ch = steelBar.charAt(i);
            if(ch == '('){
                stack.push(ch);
            } else if(ch == ')'){
                stack.pop();
                char pre = steelBar.charAt(i - 1);
                if(pre == '('){
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
