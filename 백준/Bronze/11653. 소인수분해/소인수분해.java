import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        if(N == 1) return;
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i != N; i++) {
            if (N % i == 0) {
                N = N / i;
                list.add(i);
                i = 1;
            }
        }
        list.add(N);

        list.stream().sorted().forEach(System.out::println);

        bw.flush();
        br.close();
        bw.close();
    }
}