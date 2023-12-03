
import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] edgeCount =new int[N + 1];
            ArrayList<Integer>[] list = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                list[i] = new ArrayList<>();
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int front = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list[front].add(end);
                edgeCount[end]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i < edgeCount.length; i++) {
                if (edgeCount[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int index = q.poll();

                bw.write( index + " ");

                for (int temp : list[index]) {
                    edgeCount[temp]-- ;
                    if (edgeCount[temp] == 0) {
                        q.offer(temp);
                    }
                }
            }

            bw.flush();
        }
    }