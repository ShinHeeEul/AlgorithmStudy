import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static int backtracking(int N, Stack<int[]> stack, int sum, int level) throws IOException {
        int[] map;

        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int price = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            sum += (Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
        }

        if(sum == price) System.out.println("Yes");
        else System.out.println("No");




        bw.flush();
        br.close();
        bw.close();
    }
}