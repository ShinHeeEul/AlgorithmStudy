import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String tmp = br.readLine();
            tmp = tmp.substring(1,tmp.length()-1);
            StringTokenizer st = new StringTokenizer(tmp, ",");
            ArrayList<String> arr = new ArrayList<>();
            boolean reverse = false;
            boolean err = false;
            for(int j = 0; j < N; j++) {
                arr.add(st.nextToken());
            }

            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'R') {
                    reverse = !reverse;
                } else {
                    if(arr.size() == 0) {
                        bw.write("error\n");
                        err = true;
                        break;
                    }
                    if(reverse) {
                        arr.remove(arr.size()-1);
                    } else {
                        arr.remove(0);
                    }
                }
            }
            if(err) {
                continue;
            }
            if(reverse) {
                Collections.reverse(arr);
            }
            bw.write("[");
            for(int j = 0; j < arr.size(); j++) {
                bw.write(arr.get(j));
                if(j != arr.size() -1) {
                    bw.write(",");
                }
            }
            bw.write("]\n");
        }
        bw.flush();
    }
}