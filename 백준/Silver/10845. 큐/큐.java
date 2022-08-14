import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String S = st.nextToken();
            if(S.equals("push"))
                queue.add(Integer.parseInt(st.nextToken()));
            else if(S.equals("pop")) {
                Integer tmp = queue.poll();
                if(tmp == null) tmp = -1;
                System.out.println(tmp);
            }
            else if(S.equals("size"))
                System.out.println(queue.size());
            else if(S.equals("empty"))
                System.out.println(queue.isEmpty()?1:0);
            else if(S.equals("front")) {
                Integer tmp = queue.peek();
                if(tmp == null) tmp = -1;
                System.out.println(tmp);
            }
            else if(S.equals("back")) {
                Integer tmp = null;
                while(!queue.isEmpty()) {
                    tmp = queue.poll();
                    queue2.add(tmp);
                }
                if(tmp == null) tmp = -1;
                System.out.println(tmp);
                while(!queue2.isEmpty())
                    queue.add(queue2.poll());
            }
        }



        bw.flush();
        br.close();
        bw.close();
    }
}