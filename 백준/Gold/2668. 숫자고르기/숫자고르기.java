import java.io.*;
import java.nio.Buffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Main {
    static boolean[] visited;
    static int[] arr;
    static int current;
    static Set<Integer> set;
    static boolean b;
    public static void main(String[] args) throws Exception {
        int N = read();
        arr = new int[N+1];
        visited = new boolean[N+1];
        set = new LinkedHashSet<>();
        for(int i = 1; i <= N; i++) {
            arr[i] = read();
        }

        for(int i = 1; i <= N; i++) {
            b = false;
            if(!visited[i]) {
                current = i;
                dfs(i);
            }
        }
        System.out.println(set.size());
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                System.out.println(i);
            }
        }
    }

    private static void dfs(int start) {
        if(visited[start]) {
            return;
        }

        visited[start] = true;
        int a = arr[(start)];
        if(visited[a] && a == current) {
            set.add(start);
            b = true;
            return;
        }
        dfs(a);
        if(b) {
            set.add(start);
            return;
        }
        visited[start] = false;

    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}