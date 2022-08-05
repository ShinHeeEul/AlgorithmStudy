import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;


public class Main {
    public static int backtracking(int N, Stack<int[]> stack, int sum, int level) throws IOException {
        int[] map;
        map = stack.peek();
        if(level <= N-1) {
            for (int i = 0; i < N; i++) {
                boolean bool = true;
                for(int j = 0; j < level; j++) {
                    if(i == map[j]) bool = false;
                    if(i == map[j] + level-j) bool = false;
                    if(i == map[j] - level+j) bool = false;

                }
                if(bool) {
                    map[level] = i;
                    if(level == N-1)
                    {
                        sum++;
                        continue;
                    }
                    stack.push(map);
                    sum =  backtracking(N, stack, sum, level+1);
                    stack.pop();
                    map = stack.peek();
                }

            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] map = new int[N];
        stack.push(map);
        int sum = backtracking(N,stack,0,0);
        bw.write(sum + "");



        bw.flush();
        br.close();
        bw.close();
    }
}