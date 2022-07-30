import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int N = Integer.parseInt(br.readLine());
            if(sum < N) sum = N;
            map.put(N, i + 1);
        }

        bw.write(sum + "\n" + map.get(sum));


        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}