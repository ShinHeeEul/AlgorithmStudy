import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(k);
        }

        list.stream().sorted().forEach(System.out::println);
        bw.flush();
        br.close();
        bw.close();
    }
}