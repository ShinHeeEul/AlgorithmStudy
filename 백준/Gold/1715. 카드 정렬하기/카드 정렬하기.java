import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for(int i=0; i < N;i++) queue.add(Long.parseLong(br.readLine()));


        if(N == 1) {
            System.out.println(0);
            return;
        }

        long tmp = 0;
        long ans = tmp;

        while(!queue.isEmpty()) {
            if(queue.size() == 1) break;
            tmp = queue.poll() + queue.poll();
            ans += tmp;
            queue.add(tmp);
        }

        System.out.println(ans);
    }
}