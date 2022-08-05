import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void backtracking(int N, int M, int check, Stack<Integer> stack,BufferedWriter bw) throws IOException {
        for(int i = 1; i <= N; i++) {

            if(stack.empty()) stack.push(i);
            else {
                int x = stack.pop();
                stack.push(x);
                stack.push(i);
                if(i < x)  {
                    stack.pop();
                    continue;
                }
            }

            if (stack.size() == M) {
                String S = stack.toString()
                        .replaceAll(",","");
                S = S.substring(1,S.length()-1);
                bw.write(S + "\n");
                stack.pop();
            } else if (check < M) {
                backtracking(N, M, check + 1, stack, bw);

                stack.pop();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        backtracking(N,M, 1, stack, bw);

        bw.flush();
        br.close();
        bw.close();
    }
}