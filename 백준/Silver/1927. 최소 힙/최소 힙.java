import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i =0 ;i < N ;i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                Integer tmp = minHeap.poll();
                System.out.println(tmp == null?0:tmp);
            }
            else
                minHeap.add(x);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}