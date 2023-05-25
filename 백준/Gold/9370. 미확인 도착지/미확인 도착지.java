import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main
{

    static ArrayList<Node>[] road;
    static PriorityQueue<Node> queue;

    static int min;
    static ArrayList<Integer> answer;
    static int[] dist;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());


            //초기화
            //node n개 만큼 길 생성
            road = new ArrayList[n+1];
            for(int i = 0 ; i < road.length; i++)
                road[i] = new ArrayList<>();
            queue = new PriorityQueue<>();
            dist = new int[n+1];


            //도로 생성
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                road[a].add(new Node(b,d));
                road[b].add(new Node(a,d));
            }

            //t개의 후보 위치
            int[] can = new int[t];

            for(int i = 0; i < t; i++) can[i] = Integer.parseInt(br.readLine());

            answer = new ArrayList<>();


            for(int x : can) {
                dij(s);
                int s2g = dist[g];
                int s2h = dist[h];
                int s2x = dist[x];
                dij(g);
                int g2h = dist[h];
                int g2x = dist[x];
                dij(h);
                int h2g = dist[g];
                int h2x = dist[x];

                int s2g2h2x = s2g + g2h + h2x;
                int s2h2g2x = s2h + h2g + g2x;

                if(s2g2h2x > s2h2g2x) s2g2h2x = s2h2g2x;

                if((s2x == Integer.MAX_VALUE) || (s2g2h2x == Integer.MAX_VALUE) || (s2g2h2x == Integer.MAX_VALUE)) continue;
                if(s2x < s2g2h2x) continue;
                answer.add(x);
            }

            int[] ans = new int[answer.size()];
            for(int i = 0; i < ans.length; i++) {
                ans[i] = answer.get(i);
            }
            Arrays.sort(ans);

            for(int i : ans) {
                System.out.print(i + " ");
            }

            System.out.println();
            T--;
        }

        bw.flush();
    }

    public static void dij(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        queue.add(new Node(s, 0));
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for(Node node : road[n.e_node]) {
                if(dist[node.e_node] > dist[n.e_node] + node.val){

                    dist[node.e_node] = dist[n.e_node] + node.val;
                    queue.add(new Node(node.e_node, dist[node.e_node]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int val;
        int e_node;

        public Node(int e_node, int val) {
            this.e_node = e_node;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}