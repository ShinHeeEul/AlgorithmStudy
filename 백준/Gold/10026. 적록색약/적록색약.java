import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int c1;
    static int c2;
    static Node[][] map1;
    static Node[][] map2;
    static boolean[][] visit1;
    static boolean[][] visit2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map1 = new Node[N][N];
        map2 = new Node[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                map1[i][j] = new Node(i, j, c);
                if (c == 'G') {
                    c = 'R';
                }
                map2[i][j] = new Node(i, j, c);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map1[i][j] != null) {
                    c1++;
                    BFS1(map1[i][j]);
                }
                if (map2[i][j] != null) {
                    BFS2(map2[i][j]);
                    c2++;
                }
            }
        }

        System.out.println(c1 + " " + c2);
    }

    static void BFS1(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        char exp = n.c;


        while (!queue.isEmpty()) {
            n = queue.poll();
            int i = n.i + 1;
            int j = n.j;

            if (check(i, j, exp, map1, visit1)) {
                queue.add(map1[i][j]);
                visit1[i][j] = true;
            }
            i = n.i - 1;
            j = n.j;
            if (check(i, j, exp, map1, visit1)) {
                queue.add(map1[i][j]);
                visit1[i][j] = true;
            }
            i = n.i;
            j = n.j + 1;
            if (check(i, j, exp, map1, visit1)) {
                queue.add(map1[i][j]);
                visit1[i][j] = true;
            }
            i = n.i;
            j = n.j - 1;
            if (check(i, j, exp, map1, visit1)) {
                queue.add(map1[i][j]);
                visit1[i][j] = true;
            }

            map1[n.i][n.j] = null;
        }
    }

    static void BFS2(Node n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        char exp = n.c;

        while (!queue.isEmpty()) {
            n = queue.poll();

            int i = n.i + 1;
            int j = n.j;

            if (check(i, j, exp, map2, visit2)) {
                queue.add(map2[i][j]);
                visit2[i][j] = true;
            }
            i = n.i - 1;
            j = n.j;
            if (check(i, j, exp, map2, visit2)) {
                queue.add(map2[i][j]);
                visit2[i][j] = true;
            }
            i = n.i;
            j = n.j + 1;
            if (check(i, j, exp, map2, visit2)) {
                queue.add(map2[i][j]);
                visit2[i][j] = true;
            }
            i = n.i;
            j = n.j - 1;
            if (check(i, j, exp, map2, visit2)) {
                queue.add(map2[i][j]);
                visit2[i][j] = true;
            }

            map2[n.i][n.j] = null;
        }
    }

    static boolean check(int i, int j, char c, Node[][] map, boolean[][] visit) {

        if ((i < 0) || (i >= N) || (j < 0) || (j >= N)) {
            return false;
        }

        if (visit[i][j]) {
            return false;
        }
        if(map[i][j] == null) {
            return false;
        }
        return map[i][j].c == c;
    }

    static class Node {
        int i;
        int j;
        char c;

        Node(int i, int j, char c) {
            this.i = i;
            this.j = j;
            this.c = c;
        }
    }

}