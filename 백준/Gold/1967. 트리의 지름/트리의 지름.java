import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];

        for(int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, val));
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            int[] check = new int[tree[i].size()];
            for (int j = 0; j < tree[i].size(); j++) {
                Node n = tree[i].get(j);
                check[j] = DFS(n.num, n.val, 0);
            }
            Arrays.sort(check);
            int tmp = 0;
            if(check.length >= 2) {
                tmp = check[check.length - 1] + check[check.length - 2];
            } else if(check.length == 1) {
                tmp = check[check.length - 1];
            }
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);
    }

    private static int DFS(int parent, int sum, int max) {

        for(Node n : tree[parent]) {
            int tmp = DFS(n.num, n.val + sum, max);
            if(tmp > max) {
                max = tmp;
            }
        }
        if(tree[parent].size() == 0) {
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static class Node {
        int num;
        int val;

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }
}