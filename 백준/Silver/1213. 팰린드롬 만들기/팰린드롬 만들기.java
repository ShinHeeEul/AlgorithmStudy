import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean b = true;
        Character[] cs = new Character[map.size()];

        int i = 0;
        int count = 0;
        for(char c : map.keySet()) {
            if(map.get(c) % 2 != 0) count++;
            cs[i++] = c;
        }

        if(count > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        Arrays.sort(cs);


        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for(char c : cs) {
            int a = map.get(c);
            if(a % 2 != 0) ans.append(c);
            a >>= 1;
            while(a --> 0) sb.append(c);
        }

        System.out.println(sb.toString() + ans + sb.reverse());
    }


    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }

}
