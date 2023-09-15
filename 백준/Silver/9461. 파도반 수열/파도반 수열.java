import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Long> P = new ArrayList<>();
        P.add(1L);
        P.add(1L);
        P.add(1L);
        P.add(2L);
        P.add(2L);
        P.add(3L);
        P.add(4L);
        P.add(5L);
        P.add(7L);
        P.add(9L);
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(N <= P.size()) {
                System.out.println(P.get(N-1));
                continue;
            }
            int size = P.size()-1;
            for(int j = size; j < N; j++) {
                P.add(P.get(j) + P.get(j-4));
            }
            System.out.println(P.get(N-1));

        }
    }
}
