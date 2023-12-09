import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lis = new int[N];
        int current = 0;

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(i == 0) {
                lis[0] = a;
                continue;
            }
            if(a > lis[current]) {
                lis[++current] = a;
            } else {
                int start = 0;
                int end = current;
                int mid = 0;
                while(start < end) {
                    mid = (start + end) / 2;

                    if(lis[mid] < a) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                lis[end] = a;
            }
        }

        System.out.println(current + 1);
    }
}
