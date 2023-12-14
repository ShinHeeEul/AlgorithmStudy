import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime;
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        calculate(N);
        int[] list = new int[count+1];
        int index = 1;
        list[0] = 0;
        for(int i = 0; i < N+1; i++) {
            if(isPrime[i]) {
                list[index] = list[index-1] + i;
                index++;
            }
        }


        int start = 0;
        int end = 0;
        int answer = 0;
        while((end <= count) || (start <= count)) {
            if(end == count+1) {
                start++;
                continue;
            } else if(start == count+1) {
                end++;
                continue;
            }

            int ans = list[end] - list[start];
            if(ans < N) {
                end++;
            } else if(ans > N) {
                start++;
            } else {
                answer++;
                end++;
            }
        }

        System.out.println(answer);
    }

    static void calculate(int n) {
        count = n - 1;
        isPrime = new boolean[n + 1];

        for(int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i<= Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for(int j = i *i ; j<= n; j += i) {
                    if(isPrime[j]) {
                        count--;
                    }
                    isPrime[j] = false;

                }
            }
        }
    }
}
