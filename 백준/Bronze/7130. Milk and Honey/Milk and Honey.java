import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        
        int totalHappiness = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken()); // 소 수용량
            int B = Integer.parseInt(st.nextToken()); // 벌 수용량
            
            int cowHappiness = C * M;
            int beeHappiness = B * H;
            
            totalHappiness += Math.max(cowHappiness, beeHappiness);
        }
        
        System.out.println(totalHappiness);
        
        br.close();
    }
}