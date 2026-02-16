import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int J = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int sum = 0;
        while(N-->0) {
            String s = br.readLine();
            int point = 0;
            for(char c : s.toCharArray()) {
                if(c == ' ') point++;
                else if(c >= 'A' && c <= 'Z') point += 4;
                else point += 2;
            }
            sum += point <= J ? 1 : 0;
        }

        System.out.println(sum);
    }

}