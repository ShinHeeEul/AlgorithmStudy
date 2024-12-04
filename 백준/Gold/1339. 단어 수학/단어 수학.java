import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 등장한 갯수 만큼으로 정렬
    static PriorityQueue<Node> pq;
    static Map<Character, Integer> map;
    static Map<Character, Integer> ans;
    static String[] ss;

    public static void main(String[] args) throws Exception {
        int N = read();
        pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> nodes = new ArrayList<>();
        map = new HashMap<>();
        ans = new HashMap<>();
        ss = new String[N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            ss[i] = s;
            for(int j = 0; j < s.length(); j++) {
                int a = (int) Math.pow(10,(s.length() - j));
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + a);
            }
        }

        for(char c : map.keySet()) pq.add(new Node(c, map.get(c)));

        //최대인 것부터 찾아서 배치
        int max = 9;
        while(!pq.isEmpty()) {
          Node node = pq.poll();
          ans.put(node.c, max--);
        }

        long answer = 0;
        for(String s : ss) {
            long tmp = 0;
            for(char c : s.toCharArray()) {
                tmp *= 10;
                tmp += ans.get(c);
            }
            answer += tmp;
        }

        System.out.println(answer);
    }

    public static class Node implements Comparable<Node> {
        char c;
        int val;
        public Node(char c, int val) {
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
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
