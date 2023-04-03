import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());

        //정렬 완료
        Arrays.sort(arr);

        int count = 0;
        for(int k = 0; k < N; k++) {
            int startIndex = 0;
            int endIndex = N-1;
            while(endIndex > startIndex) {
                long value = arr[startIndex] + arr[endIndex];
                if(value == arr[k]) {
                    if((startIndex != k) && (endIndex != k)) {
                        count++;
                        break;
                    }
                    else if(startIndex == k) {
                        startIndex++;
                    }
                    else if (endIndex == k) {
                        endIndex--;
                    }
                }
                else if(value < arr[k]) {
                    startIndex++;
                }
                else {
                    endIndex--;
                }
            }
        }
        System.out.println(count);
    }
}