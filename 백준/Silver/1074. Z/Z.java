import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int size;
    static int iStart;
    static int iEnd;
    static int jStart;
    static int jEnd;
    static int num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2,N);
        num = 0;
        iStart = 0;
        jStart = 0;
        iEnd = size;
        jEnd = size;
        recursive();
        System.out.println(num);
    }

    private static void recursive() {

        if((iStart == R) && (jStart == C)) {
            return;
        }

        if(size == 2) {
            if((iStart == R) && (jStart == C-1)) {
                num += 1;
            } else if((iStart == R-1) && (jStart == C)) {
                num += 2;
            } else if((iStart == R-1) && (jStart == C-1)) {
                num += 3;
            }
            return;
        }


        if((R < (iStart + iEnd)/2) && (C < (jStart + jEnd)/2)) {
            size /= 2;
            iEnd = (iStart + iEnd)/2;
            jEnd = (jStart + jEnd)/2;
            recursive();
        } else if((R < (iStart + iEnd)/2) && (C >= (jStart + jEnd)/2)) {
            num += size * size / 4;
            size/=2;
            iEnd = (iStart + iEnd)/2;
            jStart += size;
            recursive();
        } else if((R >= (iStart + iEnd)/2) && (C < (jStart + jEnd)/2)) {
            num += size * size / 2;
            size/=2;
            jEnd = (jStart + jEnd)/2;
            iStart += size;
            recursive();
        } else {
            num += (size * size / 4) * 3;
            size/=2;
            iStart += size;
            jStart += size;
            recursive();
        }
    }
}
