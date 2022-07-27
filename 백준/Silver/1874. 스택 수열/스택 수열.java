import java.util.LinkedList;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack();
        Queue<String> ans = new LinkedList<>();

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);

        int br_length = Integer.parseInt(br.readLine());
        int n = 1;

        for(int i = 0; i < br_length; i++) {
            int br_int = Integer.parseInt(br.readLine());
            while(br_int > n) {
                stack.push(n);
                ans.add("+");
                n++;
            }

            if(br_int < n) {
                if(!stack.empty()) {
                    if(br_int == stack.pop()) {
                        ans.add("-");
                    }
                    else {
                        System.out.println("NO");
                        return;
                    }
                }
            }

            if(br_int == n) {
                stack.push(n);
                stack.pop();
                ans.add("+");
                ans.add("-");
                n++;
            }

        }

        while(!ans.isEmpty()) System.out.println(ans.poll());

        input.close();
        br.close();
    }
}