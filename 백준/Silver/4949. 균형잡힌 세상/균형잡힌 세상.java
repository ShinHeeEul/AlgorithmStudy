import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack();

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);

        String br_str = br.readLine();
        while(!br_str.equals(".")) {

            String answer = "yes";
            char[] ch = br_str.toCharArray();
            for(int j = 0; j < ch.length; j++) {

                if((ch[j] == '(') || (ch[j] == '[')) stack.push(ch[j]);

                else if(ch[j] == ')') {
                    if(stack.empty()) {
                        answer = "no";
                        break;
                    }
                    else if(stack.pop() == '[') {
                        answer = "no";
                        break;
                    }
                }

                else if(ch[j] == ']') {
                    if(stack.empty()) {
                        answer = "no";
                        break;
                    }
                    else if(stack.pop() == '(') {
                        answer = "no";
                        break;
                    }
                }
            }
            if(!stack.empty()) answer ="no";
            System.out.println(answer);
            stack.clear();
            br_str = br.readLine();
        }

        input.close();
        br.close();
    }
}