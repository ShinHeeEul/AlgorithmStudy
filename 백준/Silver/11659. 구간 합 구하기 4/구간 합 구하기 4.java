import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        list.add(0);
        for(int i = 0; i < N; i++) {
            list.add(list.get(i) + Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < M; i++) {
            AtomicInteger sum = new AtomicInteger();
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(list.get(end) - list.get(start - 1) + "\n");
        }
        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}