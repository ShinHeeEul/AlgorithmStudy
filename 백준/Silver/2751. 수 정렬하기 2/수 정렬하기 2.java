import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }

        list = list.stream().sorted().collect(Collectors.toList());

        for(int i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
    }

}