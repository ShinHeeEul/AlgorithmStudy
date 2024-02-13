public class Main {

    static boolean[] visit;
    static int[] arr = new int[100001];
    static boolean[] finish;
    static int n;
    static int count;
    public static void main(String[] args) throws Exception {

        int T = read();
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < T; j++) {
            n = read();
            count = 0;
            visit = new boolean[n+1];
            finish = new boolean[n+1];
            for(int i = 1; i <= n; i++) arr[i] = read();
            for(int i = 1; i <= n; i++) dfs(arr[i]);
            sb.append(n-count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int i) {

        if(visit[i]) return;
        visit[i] = true;
        int next = arr[i];
        if(!visit[next]) dfs(next);
        else {
            if(!finish[next]) {
                count++;
                for(int j=next; j != i; j = arr[j])
                    count++;
            }
        }
        finish[i] = true;
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
