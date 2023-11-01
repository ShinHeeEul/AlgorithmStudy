import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap();

            while(n --> 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                if (map.get(category) == null) {
                    map.put(category, 2);
                } else {
                    map.put(category, map.get(category) + 1);
                }
            }
            int m = 1;
            for (String key : map.keySet()) {
                int ans = map.get(key);
                m *= ans;
            }
            System.out.println(m - 1);
        }

        bw.flush();
        bw.close();

    }
}