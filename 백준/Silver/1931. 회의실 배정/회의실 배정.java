import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static class obj implements Comparable<obj>{
        private int start;
        private int end;

        public obj(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(obj o) {
            if(this.end>o.end) return 1;
            else if(this.end<o.end) return -1;
            else return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        int N = Integer.parseInt(br.readLine());

        List<obj> T = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            T.add(new obj(start, end));
        }

        Collections.sort(T);

        int end = 0;
        int sum = 0;
        for(obj o: T) {
            if(end<=o.start) {
                end = o.end;
                sum++;
            }
        }

        bw.write(sum+"");

        bw.flush();
        br.close();
        bw.close();
    }
}