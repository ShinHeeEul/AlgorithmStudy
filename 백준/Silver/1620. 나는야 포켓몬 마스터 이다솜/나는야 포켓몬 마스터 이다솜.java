import java.util.*;
import java.io.*;


public class Main
{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

       HashMap<Integer, String> map1 = new HashMap();
       HashMap<String, Integer> map2 = new HashMap();
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            map1.put(i,s);
            map2.put(s,i);
        }
        for(int i = 0; i < M; i++) {
            String s = br.readLine();
            if(s.charAt(0) >= 'A')
                bw.write(map2.get(s) + 1 + "\n");
            else
                bw.write( map1.get(Integer.parseInt(s)-1) +"\n");
        }

        bw.flush();
    }
}