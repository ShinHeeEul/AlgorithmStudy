import java.util.*;


public class Main {
    static int node[][]; // 그래프 배열
    static int check[]; // 방문 배열
    static void bfs(int start) { // BFS 메소드
        Queue<Integer> queue = new LinkedList<>();

        System.out.print(start + " ");
        check[start] =1;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int x = queue.poll();

            for(int i=1;i<node.length;i++) { // 차례대로 1번과 연결 된 컴퓨터들을 찾아 cnt변수 증가
                if(node[x][i]==1 && check[i]!=1) {
                    System.out.print(i + " ");
                    check[i] = 1;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int start) {

        System.out.print(start + " ");
        check[start] = 1;

             for(int i = 1; i < node.length;i++) {
                 if(node[start][i] == 1 && check[i] != 1) {
                     dfs(i);
                 }
             }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt(); // 컴퓨터의 수
        int m = sc.nextInt(); // 네트워크 상에 연결되어 있는 컴퓨터 쌍의 수 즉, 간선의 수
        int start = sc.nextInt();

        node=new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0;i<m;i++) { // 그래프 구성
            int a=sc.nextInt();
            int b = sc.nextInt();
            node[a][b]=1;
            node[b][a]=1;

        }

        dfs(start);
        System.out.println();
        check = new int[n+1];
        bfs(start);


    }

}