    import java.io.*;
    import java.util.*;

    class Main {

        static ArrayList<Integer>[] arr;
        static boolean[] visited;
        static int[] answer;
        static int count;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new ArrayList[N+1];
            visited = new boolean[N+1];
            answer = new int[N+1];

            for(int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a].add(b);
            }

            for(int i = 1; i< N+1; i++) {
                visited = new boolean[N+1];
                bfs(i);
            }
            int maxVal = 0;
            for(int i = 1; i < N+1; i++) {
                maxVal = Math.max(maxVal, answer[i]);
            }

            for(int i = 1; i < N+1; i++) {
                if(answer[i] == maxVal) bw.write(i + " ");
            }


            bw.flush();
            bw.close();
        }

        public static void bfs(int start) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            visited[start] = true;

            while(!queue.isEmpty()) {
                int n = queue.poll();
                for(int i : arr[n]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        answer[i]++;
                        queue.add(i);
                    }
                }
            }

        }
    }