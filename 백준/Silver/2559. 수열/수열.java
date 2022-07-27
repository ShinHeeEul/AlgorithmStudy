import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        list.add(0);
        for(int i = 0; i < N; i++) {
            list.add(list.get(i) + Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i <= N - K; i++) {
            list2.add(list.get(i+K) - list.get(i));
        }

        bw.write(list2.stream().max(Integer::compare).get() + "");


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}