import java.io.*;
import java.math.BigInteger;

public class Main {

    public static BigInteger Fibonacci(BigInteger f1, BigInteger f2, int n, int N) {

        if(N == 0) return BigInteger.valueOf(0);
        if(N == 1) return BigInteger.valueOf(1);
        if(n >= N)
            return f1.add(f2);
        return Fibonacci(f2, f1.add(f2), n+1, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(BigInteger.valueOf(0),BigInteger.valueOf(1),2,N));

        bw.flush();
        br.close();
        bw.close();
    }
}