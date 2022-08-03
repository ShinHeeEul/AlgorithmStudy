import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chess = new char[N][M];
        for(int i = 0; i < N; i++) {
            String S = br.readLine();
            chess[i] = S.toCharArray();
        }

        int min = 1000000;
        for(int k = 0; k <= N - 8; k++) {
            for(int u = 0; u <= M - 8; u++) {
                int sum1 = 0;
                int sum2 = 0;
                for(int i = k; i < k+8; i++) {
                    for(int j = u; j < u+8; j++) {
                        if((i+j)%2 == 0) {
                            if(chess[i][j] == 'B') {
                                sum1++;
                            }
                            else {
                                sum2++;
                            }
                        }
                        else {
                            if(chess[i][j] == 'W') {
                                sum1++;
                            }
                            else{
                                sum2++;
                            }
                        }
                    }
                }
                int ans = sum1>sum2?sum2:sum1;
                if(min > ans) min = ans;
            }
        }
        bw.write(min+ "");
        br.close();
        bw.close();
    }
}