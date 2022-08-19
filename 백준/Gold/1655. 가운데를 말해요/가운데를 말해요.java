import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        int N = Integer.parseInt(br.readLine());
        for(int i =0 ;i < N ;i++) {
            int x = Integer.parseInt(br.readLine());
            if(i%2 == 0) maxHeap.add(x);
            else minHeap.add(x);
            if((minHeap.size() != 0) &&(maxHeap.size() != 0)) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int tmp = minHeap.poll();
                    maxHeap.add(tmp);
                    tmp = maxHeap.poll();
                    minHeap.add(tmp);
                }
            }

            bw.write(maxHeap.peek()+"\n");
        }





        bw.flush();
        br.close();
        bw.close();
    }
}