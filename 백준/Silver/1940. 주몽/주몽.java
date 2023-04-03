import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //100000개 -> nlogn해도 2억 안됨 -> 상관없음
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(arr).sorted().toArray();

        int startIndex = 0;
        int endIndex = N - 1;
        int count = 0;
        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < M)
                startIndex++;
            else if (arr[startIndex] + arr[endIndex] > M)
                endIndex--;
            else {
                count++;
                endIndex--;
            }
        }
        System.out.println(count);
    }
}