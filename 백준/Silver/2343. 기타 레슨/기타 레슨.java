import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        int count;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(max < arr[i]) max = arr[i];
            sum += arr[i];
        }

        int start_index = max;
        int end_index = sum;

        while(start_index <= end_index) {
            int mid = (start_index + end_index) /2;
            count = 0;
            int tmp = 0;
            for(int i : arr) {
                tmp += i;
                if(tmp == mid) {
                    count++;
                    tmp = 0;
                }
                if(tmp > mid) {
                    count++;
                    tmp = i;
                }
            }
            if(tmp != 0) count++;

            if(count > M) start_index = mid + 1;
            else end_index = mid - 1;
        }

        System.out.println(start_index);

    }
}