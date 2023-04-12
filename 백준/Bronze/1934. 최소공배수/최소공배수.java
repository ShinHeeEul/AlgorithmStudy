import java.io.*;
import java.util.*;

public class Main {


    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            System.out.println(A * B / gcd(A,B));
        }
    }

    private static int gcd(int a, int b) {
        if(a == b) return a;
        int big;
        int small;
        if(a > b) {big = a; small = b;}
        else {big = b; small = a;}
        int mod = big%small;;
        while(true) {
            if(mod == 0) break;
            big = small; small = mod;
            mod = big%small;
        }

        return small;
    }
}