import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int idx, dst;

    Edge(int idx, int dst) {
        this.idx = idx;
        this.dst = dst;
    }
}

public class Main {
    static int n, dap;
    static int[] l, t, d, r;
    static ArrayList<Edge>[] gph;

    static void go(int now) {
        dap = Math.max(dap, r[now]);
        for (Edge nxt : gph[now]) {
            r[nxt.idx] = Math.max(r[nxt.idx], r[now] + t[nxt.idx] + nxt.dst);
            if (--d[nxt.idx] == 0) {
                go(nxt.idx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        l = new int[n + 1];
        t = new int[n + 1];
        d = new int[n + 1];
        r = new int[n + 1];
        gph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
            r[i] = t[i];
            gph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (l[i] + 1 == l[j]) {
                    gph[i].add(new Edge(j, (i - j) * (i - j)));
                    d[j]++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                go(i);
            }
        }

        System.out.println(dap);
    }
}
