import java.io.*;
import java.util.*;

public class Main {

        static int[] arr;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            for(int i = 0; i < N+1; i++) {
                arr[i] = i;
            }
            for(int i = 0; i < N; i++) {
                String[] ss = br.readLine().split(" ");
                for(int  j = 0; j < N; j++) {
                    int a= Integer.parseInt(ss[j]);
                    if(a == 1) {
                        union(i+1, j+1);
                    }
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = find(Integer.parseInt(st.nextToken()));
            for(int i = 1; i < M; i++){
                int m = find(Integer.parseInt(st.nextToken()));

                if(m != k) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }

        public static boolean union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x == y) return false;
            if(x <= y) arr[y] = x;
            else {
                arr[x] = y;
            }
            return true;
        }

        public static int find(int x) {
            if(x == arr[x]) {
                return x;
            }
            return arr[x] = find(arr[x]);
        }
    }