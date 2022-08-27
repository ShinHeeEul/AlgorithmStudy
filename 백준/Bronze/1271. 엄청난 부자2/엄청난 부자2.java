import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        System.out.println(N.divide(M));
        System.out.println(N.mod(M));

        bw.flush();
        br.close();
        bw.close();
    }
}