import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for(int i = 0; i < N+1; i++) arr.add(i,i);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(check == 0) {
                a = Find(a);
                b = Find(b);
                if(a != b) arr.set(b,a);
            }
            if(check == 1) {
                a = Find(a);
                b = Find(b);
                if(a==b) bw.write("YES" + "\n");
                else bw.write("NO" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    private static int Find(int a) {
        if(arr.get(a) != a) {
            int x = Find(arr.get(a));
            arr.set(a, x);
            return arr.get(a);
        }
        return a;
    }



}