import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int fac(int f, int sum, int of) {
        if(f == of) return sum;
        sum *= f;
        return fac(f-1, sum, of);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if((K >= 1) && (N >= K))
            System.out.println(fac(N, 1, N-K) / fac(K, 1, 1));
        else if(K == 0) System.out.println(1);
        else System.out.println(0);

    }


}