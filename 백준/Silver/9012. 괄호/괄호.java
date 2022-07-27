import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int br_length = Integer.parseInt(br.readLine());

        for(int i = 0; i < br_length; i++) {

            String answer = "YES";
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < ch.length; j++) {
                if(ch[j] == '(') stack.push(ch[j]);

                else if(ch[j] == ')') {
                    if(stack.empty()) {
                        answer = "NO";
                        break;
                    } stack.pop();
                }
            }
            if(!stack.empty()) answer ="NO";
            System.out.println(answer);
            stack.clear();
        }


        br.close();
    }
}