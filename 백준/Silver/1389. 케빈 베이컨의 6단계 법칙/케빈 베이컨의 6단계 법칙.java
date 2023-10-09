import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] kevin = new int[N+1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            map.put(i+1, new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for(int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            visited[0] = true;
            visited[i] = true;
            Queue<Node> queue = new LinkedList<>();
            int count = 0;
            int level = 0;
            //BFS하고
            queue.add(new Node(i, 1));

            while((count != N) && (!queue.isEmpty())) {
                Node n = queue.poll();
                ArrayList<Integer> tmps = map.get(n.val);
                for(int tmp : tmps) {
                    if(!visited[tmp]) {
                        visited[tmp] = true;
                        queue.add(new Node(tmp, n.level+1));
                        count++;
                        level += n.level;
                    }
                }

            }
            kevin[i] = level;

            //level 저장
            if(min > level) {
                min = level;
                ans = i;
            }
        }

        System.out.println(ans);
    }

    public static class Node {
        int val;
        int level;

        public Node(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
}