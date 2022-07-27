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
            Integer tmp = Integer.parseInt(br.readLine());
            if((tmp == 0) && (!stack.empty())) stack.pop();
            else stack.push(tmp);
        }

        int answer = 0;
        while(!stack.empty())
            answer += stack.pop();

        System.out.println(answer);
        br.close();
    }
}