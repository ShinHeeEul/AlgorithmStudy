import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[12];
        int T = Integer.parseInt(br.readLine());
        DP(0);
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(arr[N]);
        }
    }

    private static void DP(int sum) {
        if(sum > 11) return;
        arr[sum]++;
        for(int j = 1; j <= 3; j++) {
            DP(sum + j);
        }
    }
}