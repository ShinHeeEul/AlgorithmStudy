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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] len = new int[N];
        int min = 100000;
        int ans = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {

                    int sum = len[i] + len[j] + len[k];
                    int tmp = M-sum;
                    if(tmp < 0) continue;
                    if(min > tmp) {
                        min = tmp;
                        ans = sum;
                    }
                }

            }
        }

        bw.write(ans + "");


        bw.flush();
        br.close();
        bw.close();
    }
}