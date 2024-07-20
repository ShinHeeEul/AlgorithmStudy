import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static long[] segments;
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            size = 1;
            while (size < N) {
                size <<= 1;
            }

            segments = new long[(size << 1) + 1];
            Arrays.fill(segments, 1);

            st = new StringTokenizer(br.readLine());
            for (int i = size + 1; i < size + N + 1; i++) {
                int a = Integer.parseInt(st.nextToken());
                if(a > 0) {
                    segments[i] = 1;
                } else if(a < 0) {
                    segments[i] = -1;
                } else {
                    segments[i] = 0;
                }
            }

            int segmentSize = segments.length - 1;

            while (segmentSize > 1) {
                segments[(segmentSize + 1) >> 1] = segments[segmentSize - 1] * segments[segmentSize];
                segmentSize -= 2;
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (c == 'C') {
                    update(a, b);
                } else {
                   long ans =  query(a, b, 2, 1, size);
                   if(ans < 0) {
                       sb.append("-");
                   } else if(ans > 0) {
                        sb.append("+");
                   } else {
                       sb.append("0");
                   }
                }
            }

            sb.append("\n");
       }
        System.out.println(sb);
    }

    private static void update(int i , int v) {
        int segmentSize = i + size;
        if(v > 0) {
            segments[segmentSize] = 1;
        } else if(v < 0) {
            segments[segmentSize] = -1;
        } else {
            segments[segmentSize] = 0;
        }
        while(segmentSize > 1) {
            segmentSize = (segmentSize + 1) >> 1;
            segments[segmentSize] = segments[segmentSize << 1] * segments[(segmentSize << 1) - 1];

        }
    }

    private static long query(int left, int right, int node, int start, int end) {
        if(left > end || right < start) {
            return 1;
        }

        if(left <= start && end <= right) {
            return segments[node];
        }

        int mid = (start + end) / 2;
        return query(left, right, (node << 1) - 1, start, mid) * query(left, right, node << 1, mid + 1, end);
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }

}
