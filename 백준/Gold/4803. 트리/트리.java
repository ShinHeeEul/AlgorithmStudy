import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int N;
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("beack-joon/src/input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 1;
        String s;
        while(!(s = br.readLine()).equals("0 0")) {
            bw.write("Case " + cnt + ": ");
            StringTokenizer st = new StringTokenizer(s);
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];
            for(int i = 1; i <= N; i++) arr[i] = i;
            visit = new boolean[N + 1];
            while(M --> 0) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                union(n1, n2);

            }
            HashSet<Integer> set = new HashSet<>();
            for(int i = N; i > 0; i--) {
                if(visit[arr[i]]) visit[find(arr[i])] = true;
                if(!visit[find(arr[i])])
                    set.add(find(arr[i]));
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
}
