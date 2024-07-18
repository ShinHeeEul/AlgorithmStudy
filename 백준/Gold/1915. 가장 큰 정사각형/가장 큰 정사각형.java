import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        int ans = 1;
        
        int[][] box = new int[N + 1][M + 1];
        boolean b = false;
        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            for(int j = 1; j <= M; j++) {
                int a = Integer.parseInt(s.charAt(j-1) + "");
                if(a == 1) b = true;
                box[i][j] = a;
                if(box[i-1][j] >= 1 && box[i][j-1] >= 1 && box[i-1][j-1] >= 1 && box[i][j] >= 1) {
                    box[i][j] = Math.min(box[i][j-1], Math.min(box[i-1][j], box[i-1][j-1])) + 1;
                }
                ans = Math.max(ans, box[i][j]);
            }
        }
        System.out.print(b ? ans * ans : 0);


    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == '-') {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative? -o:o;
    }

}
