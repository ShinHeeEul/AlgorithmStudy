import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static ArrayList<Integer> answer;
    static Node[][] map;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        map = new Node[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = new Node(i, j, Integer.parseInt(""+s.charAt(j)));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N;j++) {
                if(map[i][j].val == 1) {
                    BFS(i,j);
                }
            }
        }

        System.out.println(answer.size());

        Collections.sort(answer);
        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    private static void BFS(int i, int j) {
        int num = 1;
        Queue<Node> queue = new LinkedList<>();

        queue.add(map[i][j]);
        map[i][j].val = 0;

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            int ni = n.i+1;
            int nj = n.j;
            if(check(ni,nj)) {
                queue.add(map[ni][nj]);
                map[ni][nj].val = 0;
                num++;
            }
            ni = n.i;
            nj = n.j+1;
            if(check(ni, nj)) {
                queue.add(map[ni][nj]);
                map[ni][nj].val = 0;
                num++;
            }
            ni = n.i-1;
            nj = n.j;
            if(check(ni, nj)) {
                queue.add(map[ni][nj]);
                map[ni][nj].val = 0;
                num++;
            }
            ni = n.i;
            nj = n.j-1;
            if(check(ni, nj)) {
                queue.add(map[ni][nj]);
                map[ni][nj].val = 0;
                num++;
            }
        }
        answer.add(num);
    }

    private static boolean check(int i, int j) {
        if((i < 0) || (i >= N) || (j < 0) || (j >= N)) {
            return false;
        }
        if(map[i][j].val == 0) {
            return false;
        }
        return true;
    }

    private static class Node {
        int i;
        int j;
        int val;
        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

}
