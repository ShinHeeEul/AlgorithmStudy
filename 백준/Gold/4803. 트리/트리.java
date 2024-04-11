import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 1;
        while((N= read()) != 0) {
            int M = read();
            bw.write("Case " + cnt + ": ");
            arr = new int[N + 1];
            for(int i = 1; i <= N; i++) arr[i] = i;
            visit = new boolean[N + 1];
            while(M --> 0) {
                int n1 = read();
                int n2 = read();
                union(n1, n2);

            }
            HashSet<Integer> set = new HashSet<>();
            for(int i = N; i > 0; i--) {
                int fi = find(arr[i]);
                if(visit[arr[i]]) visit[fi] = true;
                if(!visit[fi]) set.add(fi);
            }
            int size = set.size();
            if(size <= 0) bw.write("No trees.\n");
            else if(size == 1) bw.write("There is one tree.\n");
            else bw.write("A forest of " + size + " trees.\n");
            cnt++;
        }
        bw.flush();
        bw.close();
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            visit[x] = true;
            return true;
        }
        else if(x > y) arr[x] = y;
        else arr[y] = x;
        return false;
    }

    private static int find(int x) {
        if(x == arr[x]) return x;
        return arr[x] = find(arr[x]);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
