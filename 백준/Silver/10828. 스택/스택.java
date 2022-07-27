import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int br_length = Integer.parseInt(br.readLine());

        for(int i = 0; i < br_length; i++) {
            String[] temp = br.readLine().split(" ");
            if (temp[0].equals("push")) stack.push(Integer.parseInt(temp[1]));
            else if (temp[0].equals("pop")) {
                if (!stack.empty()) System.out.println(stack.pop());
                else System.out.println(-1);
            } else if (temp[0].equals("size")) System.out.println(stack.size());
            else if (temp[0].equals("empty")) System.out.println(stack.empty() ? 1 : 0);
            else if (temp[0].equals("top")) {
                if (stack.empty()) System.out.println(-1);
                else {
                    Integer tmp = stack.pop();
                    System.out.println(tmp);
                    stack.push(tmp);
                }
            }
        }

        br.close();
    }
}