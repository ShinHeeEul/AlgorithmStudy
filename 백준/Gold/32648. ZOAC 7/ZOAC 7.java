public class Main {


    static Node[][] dp;
    static Node[][] rdp;
    public static void main(String[] args) throws Exception {

        int N = read();
        int M = read();
        char[][] arr = new char[N + 1][M + 1];
        dp = new Node[N + 1][M + 1];
        rdp = new Node[N + 1][M + 1];

        for(int i = 0; i <= N; i++) {
            rdp[i][0] = new Node(0,0,0,0);
            dp[i][0] = new Node(0,0,0,0);
        }
        for (int i = 0; i <= M; i++) {
            rdp[0][i] = new Node(0,0,0,0);
            dp[0][i] = new Node(0,0,0,0);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                arr[i][j] = (char) System.in.read();
                System.in.read();
            }
        }

        // dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1])
        // reverseDP
        // 5 : 211111
        // 4 : 332211
        // 3 : 443211
        // 2 : 443322
        // 1 : 553332

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                rdp[i][j] = Node.max(rdp[i-1][j], rdp[i][j - 1]);
                rdp[i][j].add(arr[N + 1 - i][M + 1 - j]);
                dp[i][j] = Node.max(dp[i][j-1], dp[i-1][j]);
                dp[i][j].add(arr[i][j]);
            }
        }

//        for(int i = 1; i  <= N; i++) {
//            for(int j =1; j <= M; j++) {
//                System.out.print(dp[i][j].z);
//            }
//            System.out.println();
//        }
//
//        System.out.println("---------------");
//        for(int i = 1; i  <= N; i++) {
//            for(int j =1; j <= M; j++) {
//                System.out.print(rdp[i][j].z);
//            }
//            System.out.println();
//        }

        Node node = new Node(0,0,0,0);
        for(int i = 1; i <= N; i++) {
            node.a = Math.max(node.a, dp[i][M].a + rdp[N - i][M].a);
            node.o = Math.max(node.o, dp[i][M].o + rdp[N - i][M].o);
            node.c = Math.max(node.c, dp[i][M].c + rdp[N - i][M].c);
            node.z = Math.max(node.z, dp[i][M].z + rdp[N - i][M].z);
        }

        for(int i = 1; i <= M; i++) {
            node.a = Math.max(node.a, dp[N][i].a + rdp[N][M - i].a);
            node.o = Math.max(node.o, dp[N][i].o + rdp[N][M - i].o);
            node.z = Math.max(node.z, dp[N][i].z + rdp[N][M - i].z);
            node.c = Math.max(node.c, dp[N][i].c + rdp[N][M - i].c);
        }
        StringBuilder sb = new StringBuilder();

        sb.append(node.z).append(" ")
                .append(node.o).append(" ")
                .append(node.a).append(" ")
                .append(node.c);
        System.out.println(sb);

        // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
        // DP
        // 1 : 011122
        // 2 : 011223
        // 3 :
        // 4 :
        // 5 :
    }

    static class Node {
        int a;
        int o;
        int z;
        int c;

        Node(int a, int o, int z, int c) {
            this.a = a;
            this.o = o;
            this.z = z;
            this.c = c;
        }

        public void add(char c) {
            if(c == 'A') a++;
            if(c == 'C') this.c++;
            if(c == 'O') o++;
            if(c == 'Z') z++;
        }

        public static Node max(Node o1, Node o2) {
            return new Node(
                    Math.max(o1.a, o2.a),
                    Math.max(o1.o, o2.o),
                    Math.max(o1.z, o2.z),
                    Math.max(o1.c, o2.c)
            );

        }
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
