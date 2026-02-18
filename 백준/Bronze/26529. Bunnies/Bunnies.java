import java.io.*;

public class Main {

    public static int Fibonacci(int f1, int f2, int n, int N) {

        if(n >= N) return f1+f2;
        return Fibonacci(f2, f1+f2, n+1, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0 || N == 1) System.out.println(1);
            else System.out.println(Fibonacci(1,1,2,N));
        }
        br.close();
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }
}