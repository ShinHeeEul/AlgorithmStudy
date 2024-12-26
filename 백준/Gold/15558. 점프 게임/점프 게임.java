import java.util.*;
import java.io.*;
import java.lang.*;

/*
재귀함수
3가지 경우, 각각 맵 상태를 파라미터로 관리
더 이상 갈수 없거나, 칸을 벗어나면 종료
*/
public class Main {
    static int n, k;
    static int answer = 0;
    static char[] left, right;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        left = br.readLine().toCharArray();
        right = br.readLine().toCharArray();
        visited = new boolean[n][2];
    
        func('l', 0, 0);
        System.out.print(answer);
    }

    public static boolean func(char line, int idx, int time) {
        
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(line, idx, time));
        visited[0][0] = true;
        
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            
            char nl = node.line;
            int ni = node.idx;
            int nt = node.time;
            
            //클리어
            if(ni + k >= n) {
                answer = 1;
                return true;
            }
            
            
            //1번 행동
            if(nl == 'l' && left[ni + 1] == '1') {
                left[ni + 1] = '0';
                stack.add(new Node('l', ni + 1, nt + 1));
            } else if(nl == 'r' && right[ni + 1] == '1') {
                right[ni + 1] = '0';
                stack.add(new Node('r', ni + 1, nt + 1));
            }
            
            //2번 행동
            if(nl == 'l' && ni-1 > nt && left[ni - 1] == '1') {
                left[ni - 1] = '0';
                stack.add(new Node('l', ni - 1, nt + 1));
            } else if(nl == 'r' && ni-1 > nt && right[ni - 1] == '1') {
                right[ni - 1] = '0';
                stack.add(new Node('r', ni - 1, nt + 1));
            }
            
            //3번행동
            if(nl == 'l' && right[ni + k] == '1') {
                right[ni + k] = '0';
                stack.add(new Node('r', ni + k, nt + 1));
            } else if(nl == 'r' && left[ni + k] == '1') {
                left[ni + k] = '0';
                stack.add(new Node('l', ni + k, nt + 1));
            }
            
        }
        return false;
       
        
        
    }
    
    public static class Node {
        char line;
        int idx;
        int time;
        
        public Node(char line, int idx, int time) {
            this.line = line;
            this.idx = idx;
            this.time = time;
        }
    }
}
