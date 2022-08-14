import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr.add(Integer.parseInt(st.nextToken()));

        arr = (ArrayList<Integer>) arr.stream().sorted()
                .collect(Collectors.toList());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int min = 0;
            int max = N-1;
            boolean find = false;
            if(arr.get(max) < tmp) {
                System.out.println(0);
                continue;
            }
            else if(arr.get(min) > tmp) {
                System.out.println(0);
                continue;
            }
            else {
                while(min <= max) {
                int mid = (min + max) / 2;
                if(arr.get(mid) < tmp) min = mid + 1;
                else if(arr.get(mid) > tmp) max = mid - 1;
                else {
                    System.out.println(1);
                    find = true;
                    break;
                }
            }
                if(!find)
                    System.out.println(0);
            }
        }



        bw.flush();
        br.close();
        bw.close();
    }
}