import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[K+1][N+1];
            for(int j = 0; j < arr.length; j++) {
                for(int k = 1; k < arr[j].length; k++) {
                    if(j == 0) arr[j][k] = k;
                    else if(k == 0) arr[j][k] = 1;
                    else arr[j][k] = arr[j][k-1] + arr[j-1][k];
                }
            }
            System.out.println(arr[K][N]);
        }




        bw.flush();
        br.close();
        bw.close();
    }
}