import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int tmp = 0;
        Stack<Integer> stack = new Stack<>();
        char before = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(tmp * 10 + Integer.parseInt(before + ""));
                tmp = 0;
            } else if(c == ')') {
                int pop = stack.pop();
                tmp *= pop % 10;
                tmp += pop/10-1;
            } else {
                tmp++;
                before = c;
            }
        }

        while(!stack.isEmpty()) tmp += stack.pop();
        System.out.println(tmp);
    }
}
