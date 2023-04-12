import java.io.*;
import java.util.*;

public class Main {


    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new boolean[10000000];

        System.out.println(decimal(N));
    }

    private static int decimal(int N) {

        for(int i = 2; i < Math.sqrt(arr.length); i++) {
            if(!arr[i]) {
                if(i >= N) if(pellindrom(i)) return i;
                for(int j = i * i; j < arr.length; j+=i)
                    arr[j] = true;
            }
        }

        for(int i = (int) Math.sqrt(arr.length); i < arr.length; i++) {
            if(!arr[i]) {
                if(i >= N) if(pellindrom(i)) return i;
            }
        }
        return -1;
    }

    private static boolean pellindrom(int i) {
        char[] S = String.valueOf(i).toCharArray();

        for(int j = 0; j < S.length/2; j++)
            if(S[j] != S[S.length - j - 1]) return false;
        return true;
    }
}