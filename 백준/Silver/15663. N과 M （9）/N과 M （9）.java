import java.io.*;
import java.util.*;

public class Main {

    static HashSet<String> list;
    static int[] mList;
    static boolean[] visit;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mList = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            mList[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,  new ArrayList<>());

        List<String> li = new ArrayList<>();
        for(String s : list) {
            li.add(s);
        }

        Collections.sort(li, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer st1 = new StringTokenizer(o1);
                StringTokenizer st2 = new StringTokenizer(o2);

                while(st1.hasMoreTokens()) {
                    Long l1 = Long.parseLong(st1.nextToken());
                    Long l2 = Long.parseLong(st2.nextToken());

                    if(l1 < l2) {
                        return -1;
                    } else if(l1 > l2) {
                        return 1;
                    }
                }
                return 0;
            }
        });

        for(String s: li) {
            bw.write(s + "\n");
        }

        bw.flush();
    }

    public static void backTracking(int count, ArrayList<Integer> l) {
        if(M == count) {
            StringBuilder s = new StringBuilder();
            for(int i : l) {
                s.append(i);
                s.append(" ");
            }
            list.add(s.toString());
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            if(l.size() == 0) {
                l.add(mList[i]);
                backTracking(count + 1, l);
                l.remove(l.size() - 1);
                visit[i] = false;
                continue;
            }
            l.add(mList[i]);
            backTracking(count + 1, l);
            l.remove(l.size() - 1);
            visit[i] = false;
        }
    }
}
