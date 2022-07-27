import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class Main {

    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = st.nextToken().toCharArray();
        for(int i = 0;i < c.length; i++) {
            if ((c[i] - 32 >='A') && (c[i] - 32 <= 'Z')) {
                c[i] -= 32;
            }
            if(map.containsKey(c[i])) map.put(c[i],map.get(c[i]) + 1);
            else map.put(c[i],1);
        }

        AtomicReference<Character> ch = new AtomicReference<>((char) 0);
        AtomicInteger max = new AtomicInteger();
        map.keySet().stream().filter(k -> (map.get(k) > max.get()))
        .forEach(k -> {
            max.set(map.get(k));
            ch.set(k);
        });

        map.keySet().stream().filter(k -> ((map.get(k) == max.get()) && (k != ch.get())))
                        .forEach(k -> ch.set('?'));

        bw.write(ch.get());
        bw.flush();

        input.close();
        br.close();
        bw.close();
    }
}