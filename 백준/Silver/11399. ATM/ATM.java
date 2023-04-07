import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        int sum = 0;

        for(int i = 0 ; i < N; i++) {
                sum += arr[i];
                ans += sum;
        }

        System.out.println(ans);

        bw.flush();
        bw.close();
    }

}