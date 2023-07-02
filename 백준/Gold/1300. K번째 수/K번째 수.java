import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;
        long answer = -1;
        while(start <= end) {
            //중간 값
            long middle = (start + end) / 2;
            //중앙값보다 작은 수
            int cnt = 0;
            //중앙값 보다 작은 수 계산
            for(int i = 1; i <= N; i++)
                cnt += Math.min((middle / i), N);

            if(cnt < K)
                start = middle + 1;
            else {
                end = middle - 1;
                answer = middle;
            }
        }
        System.out.println(answer);
    }
}