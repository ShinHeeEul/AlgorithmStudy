import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main
{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] ans = new int[N+1];
        //이전 값을 이용하게 해서 풀자
        //ex) 10 -> 5나 9 중 더 빠른 애
        //6 -> 2나 3중 더 빠른 애 + 1
        if(N >= 2) ans[2] = 1;
        if(N >= 3) ans[3] = 1;
        for(int i = 4; i < N+1; i++) {
            int min = Integer.MAX_VALUE;
            if(i % 3 == 0) {
               if(min > ans[i/3] + 1) min = ans[i/3] + 1;
            }
            if(i % 2 == 0) {
                if(min > ans[i/2] + 1) min = ans[i/2] + 1;
            }
            if(min > ans[i-1] + 1) min = ans[i-1] + 1;
            ans[i] = min;
        }

        System.out.println(ans[N]);
    }
}