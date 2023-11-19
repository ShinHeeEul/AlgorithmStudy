import java.io.*;
import java.util.*;

public class Main {

    static LinkedHashSet<String> list;
    static int[] mList;
    static boolean[] visit;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new LinkedHashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mList = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            mList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(mList);

        backTracking(0,  new ArrayList<>());


        for(String s: list) {
            bw.write(s + "\n");
        }

        bw.flush();
    }

    public static void backTracking(int count, ArrayList<Integer> l) {
        if(M == count) {
            String s = "";
            for(int i : l) {
                s += i;
                s += " ";
            }
            list.add(s);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i]) {
                continue;
            }
            visit[i] = true;
            l.add(mList[i]);
            backTracking(count + 1, l);
            l.remove(l.size() - 1);
            visit[i] = false;
        }
    }
}
