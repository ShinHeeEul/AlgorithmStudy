import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int tmp = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> multipleStack = new Stack<>();
        char before = 0;
        int current = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(tmp);
                multipleStack.push(Integer.parseInt(before + ""));
                tmp = 0;
            } else if(c == ')') {
                int allK = stack.pop()-1;
                int K = multipleStack.pop();
                tmp *= K;
                tmp += allK;

            } else {
                tmp++;
                before = c;
            }
        }

        while(!stack.isEmpty()) tmp += stack.pop();
        System.out.println(tmp);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
