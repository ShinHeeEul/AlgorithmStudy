import java.io.*;
import java.util.*;

public class Main {
    
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer>[] arr = new ArrayList[N];
        int[] check;

        //그래프 생성
        for(int i = 0; i < N; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        for(int i = 0; i < N; i++) {
            int depth = 0;
            //시작 위치 i
            stack.push(i);
            check = new int[N];

            //stack이 빌때까지 반복
            while (!stack.isEmpty()) {
                int tmp = stack.pop();

                depth++;
                check[tmp] = 1;

                //종료 조건
                if (depth == 5) {
                    System.out.println(1);
                    return;
                }

                boolean b = false;

                    for (int k : arr[tmp]) {
                        if(check[k] != 0) continue;
                        stack.push(k);
                        b = true;
                    }
                    if(!b) depth--;
            }
        }
        System.out.println(0);
        bw.flush();
        bw.close();*/

        int N;
        int M;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        
        A = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) 
            A[i] = new ArrayList<Integer>();
        
        for(int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        
        for(int i = 0; i < N; i++) {
            DFS(i,1);
            if(arrive) break;
        }
        if(arrive)
            System.out.println("1");
        else
            System.out.println("0");
        
    }

    private static void DFS(int now, int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[now] = true;
        for(int i : A[now]) {
            if(!visited[i]) DFS(i, depth + 1);
        }
        
        visited[now] = false;
    }

}