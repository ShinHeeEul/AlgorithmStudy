import java.io.*;

public class Main {

    public static int Fibonacci(int f1, int f2, int n, int N) {

        if(N == 0) return 0;
        if(N == 1) return 1;
        if(n >= N)
            return f1+f2;
        return Fibonacci(f2, f1+f2, n+1, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(0,1,2,N));

        bw.flush();
        br.close();
        bw.close();
    }
}