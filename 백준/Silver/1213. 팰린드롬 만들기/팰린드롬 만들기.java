import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        boolean b = false;
        char cc = ' ';
        for (char c : map.keySet()) {
            int i = map.get(c);

            if (i % 2 != 0 && !b) {
                cc = c;
                b = true;
            } else if (i % 2 != 0) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }


        Character[] array = map.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .toArray(Character[]::new);


        String ss = "";
        if(b) {
            ss += cc;
            map.put(cc, map.get(cc)- 1);
        }

            for(char c : array) {
                while(map.get(c) != 0) {
                    ss = c + ss;
                    ss = ss + c;
                    map.put(c, map.get(c) - 2);
                }
            }

        System.out.println(ss);
    }

}