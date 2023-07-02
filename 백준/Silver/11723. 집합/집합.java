import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            if(S.equals("all")) {
                for(int j = 1; j <= 20; j++) set.add(j);
                continue;
            }
            else if(S.equals("empty")) {
                set = new HashSet<>();
                continue;
            }
            int x = Integer.parseInt(st.nextToken());
            switch(S) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "check":
                    if(set.contains(x)) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "toggle":
                    if(set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;

            }

        }

        bw.flush();
        bw.close();
    }
}