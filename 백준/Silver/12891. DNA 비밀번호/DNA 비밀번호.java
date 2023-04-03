import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] arg) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        //nlogn
        char[] str = new char[S];
        String tmp = br.readLine();
        for(int i = 0; i < S; i++) {
            str[i] = tmp.charAt(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] ACGT  = new int[4];
        for(int i = 0; i < 4; i++) ACGT[i] = Integer.parseInt(st.nextToken());

        int startIndex = 0;
        int endIndex = P;

        int[] count = new int[4];
        int ans = 0;
        for (int i = startIndex; i < endIndex; i++) {
            switch (str[i]) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }
        }
        boolean check = true;
        for(int k = 0; k < 4; k++)
            if(count[k] < ACGT[k]) check = false;
        if(check) ans++;
        while(endIndex < S) {

            switch (str[startIndex]) {
                case 'A':
                    count[0]--;
                    break;
                case 'C':
                    count[1]--;
                    break;
                case 'G':
                    count[2]--;
                    break;
                case 'T':
                    count[3]--;
                    break;
            }
            switch (str[endIndex]) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }
            startIndex += 1;
            endIndex += 1;
            check = true;
            for(int k = 0; k < 4; k++)
            if(count[k] < ACGT[k]) check = false;
            if(check) ans++;
        }
        System.out.println(ans);
    }
}