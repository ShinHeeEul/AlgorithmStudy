import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A;
        Deque<Integer> B = new LinkedList<>();
        StringTokenizer stt = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(stt.nextToken());
            if(A == 0) {
                B.addLast(C);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int c = Integer.parseInt(st.nextToken());
            B.addFirst(c);
            bw.write(B.removeLast() + " ");
        }

        bw.flush();
    }
}