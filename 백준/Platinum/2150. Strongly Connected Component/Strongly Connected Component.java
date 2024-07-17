import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {


    static Stack<Integer> stack = new Stack<>();

    //A -> B
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] oList;
    static ArrayList<ArrayList<Integer>> answer;
    static ArrayList<Integer> ans;
    static boolean[] visited;
    static boolean[] finished;

    //코사라주 알고리즘
    public static void main(String[] args) throws Exception {
        int V = read();
        int E = read();

        list = new ArrayList[V+1];
        oList = new ArrayList[V + 1];
        visited = new boolean[V+1];
        finished = new boolean[V+1];
        answer = new ArrayList<>();

        for(int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
            oList[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            int a = read();
            int b = read();
            list[a].add(b);
            oList[b].add(a);
        }

        // SCC
        for(int i = 1; i <= V; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i);
        }

        while(!stack.isEmpty()) {
            int i = stack.pop();
            if(finished[i]) continue;
            ans = new ArrayList<>();
            finished[i] = true;
            oDfs(i);
            answer.add(ans);
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(answer.size());

        for(int i = 0; i < answer.size(); i++) {
            Collections.sort(answer.get(i));
        }
        Collections.sort(answer, (o1, o2) -> o1.get(0) - o2.get(0));
        for(int i = 0; i < answer.size(); i++) {
            ArrayList<Integer> test = answer.get(i);
            for(int j : test) {
                sb.append(j).append(" ");
            }
            sb.append("-1\n");
        }

        System.out.println(sb);

    }

    public static void oDfs(int i) {
        ans.add(i);
        for(int j : oList[i]) {
            if(finished[j]) continue;
            finished[j] = true;
            oDfs(j);
        }
    }

    public static void dfs(int i) {
        for(int j : list[i]) {
            if(visited[j])
                continue;
            visited[j] = true;
            dfs(j);
        }
        stack.push(i);
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();

        if (d == '-') {

            negative = true;
            d = System.in.read();
        }
        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }

}
