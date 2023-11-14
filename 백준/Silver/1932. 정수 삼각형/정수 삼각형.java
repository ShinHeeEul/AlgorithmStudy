import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] triangle = new ArrayList[N+1];

        for(int i = 0; i < N+1 ; i++) {
            triangle[i] = new ArrayList<>();
        }
        triangle[1].add(Integer.parseInt(br.readLine()));
        for(int i = 2; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < i; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    triangle[i].add(triangle[i - 1].get(j) + t);
                } else if(j == i - 1) {
                    triangle[i].add(triangle[i - 1].get(j-1) + t);
                } else {
                    triangle[i].add(
                            Math.max(triangle[i - 1].get(j - 1), triangle[i - 1].get(j)) + t
                    );
                }
            }
        }

        Collections.sort(triangle[N]);
        System.out.println(triangle[N].get(N-1));

    }
}
