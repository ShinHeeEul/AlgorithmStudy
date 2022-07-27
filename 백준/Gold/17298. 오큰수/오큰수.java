import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack();

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int br_length = Integer.parseInt(br.readLine());
        int[] A = new int[1000000];
        //ArrayList<Integer> A = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < br_length; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        //Integer.parseInt(stk.nextToken());

        for(int i = 0; i < br_length; i++) {
            while(!stack.empty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.empty()) {
            A[stack.pop()] = -1;
        }

        for(int i = 0; i < br_length; i++) {
            bw.write(A[i] + " ");
        }
        bw.flush();


        input.close();
        br.close();
        bw.close();
    }
}