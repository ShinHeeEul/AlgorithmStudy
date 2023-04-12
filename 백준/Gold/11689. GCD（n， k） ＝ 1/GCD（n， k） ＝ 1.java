import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        cnt = N;
        System.out.println(OilerP(N));
    }

    //가장 중요한 부분
    //P[i] = P[i] - P[i] / K
    //P[i]에서 K의 배수 값을 다 빼주기
    private static long OilerP(long N) {
        for (long i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                //그니까 i로 나눠 떨어지면 그 배수를 다 빼주는 거지
                cnt = cnt - cnt / i;
                //얘는 그 배수가 없어졌으니 숫자를 줄여도 되는거고
                while(N % i == 0) N /= i;
            }
        }

        //N이 남아있을 시, N의 배수 다 빼주기..?
        // 제곱근까지만 해서
        if(N > 1) cnt = cnt - cnt / N;
        return cnt;
    }
}