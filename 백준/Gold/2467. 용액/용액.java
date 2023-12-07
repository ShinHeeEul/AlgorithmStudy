import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        int before = 0;
        while(start < end) {
            int ans = Math.abs(arr[end] + arr[start]);

            if(min > ans) {
                min = ans;
                ans1 = arr[start];
                ans2 = arr[end];
            }
            if(Math.abs(arr[start]) < Math.abs(arr[end])) {
                end--;
                continue;
            }
            start++;
        }

        System.out.println(ans1 + " " + ans2);

    }
}
