import java.io.*;

public class Main {
    static final int MAXN = 600000;
    static int[] left = new int[MAXN];
    static int[] right = new int[MAXN];
    static long[] color = new long[MAXN];
    static int[] time = new int[MAXN];
    static int nodeCnt = 1;
    static int curTime = 1;

    static int newNode() {
        left[nodeCnt] = right[nodeCnt] = -1;
        color[nodeCnt] = -1;
        time[nodeCnt] = 0;
        return nodeCnt++;
    }

    static int child(int cur, int dir) {
        int nxt = (dir == 0 ? left[cur] : right[cur]);
        if (nxt == -1) {
            nxt = newNode();
            if (dir == 0) left[cur] = nxt;
            else right[cur] = nxt;
        }
        return nxt;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
        int q = fs.nextInt();
        long C = fs.nextLong();
        left[0] = right[0] = -1;
        color[0] = -1;
        time[0] = 0;

        for (int i = 0; i < q; i++) {
            int t = fs.nextInt();
            if (t == 1) {
                long x = fs.nextLong();
                String s = fs.next();
                int cur = 0;
                for (char ch : s.toCharArray()) cur = child(cur, ch == 'L' ? 0 : 1);
                color[cur] = x;
                time[cur] = curTime++;
            } else {
                String s = fs.next();
                int cur = 0;
                long diff = 0;
                int bestTime = 0;
                long bestColor = -1;
                long bestDiff = 0;
                for (char ch : s.toCharArray()) {
                    int dir = ch == 'L' ? 0 : 1;
                    diff += dir == 0 ? 1 : -1;
                    cur = child(cur, dir);
                    if (time[cur] > bestTime) {
                        bestTime = time[cur];
                        bestColor = color[cur];
                        bestDiff = diff;
                    }
                }
                if (bestTime == 0) out.append(-1).append('\n');
                else {
                    long ans = (bestColor + (diff - bestDiff)) % C;
                    if (ans < 0) ans += C;
                    out.append(ans).append('\n');
                }
            }
        }
        System.out.print(out.toString());
    }

    static class FastScanner {
        private final byte[] buf = new byte[1 << 16];
        private int len = 0, ptr = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }
        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len == -1) return -1;
            }
            return buf[ptr++];
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && c <= 32);
            if (c == -1) return null;
            do sb.append((char) c);
            while ((c = readByte()) != -1 && c > 32);
            return sb.toString();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
