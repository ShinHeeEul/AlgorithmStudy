import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    static HashMap<String, Integer> map = new HashMap<>();
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        K = read();

        for (int i = 1; i <= 2 * N; i++) {
            combination(i + 1, 1, "" + i);
        }

        for (int i = 0; i < M; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < K; j++) {
                list.add(read());
            }

            for(String s : map.keySet()) {
                boolean b = true;
                StringTokenizer stt = new StringTokenizer(s, "/");
                ArrayList<Integer> tmp = new ArrayList<>();

                while(stt.hasMoreTokens()) {
                    tmp.add(Integer.parseInt(stt.nextToken()));
                }
                for(Integer c : list) {
                        if (!tmp.contains(c)) {
                            b = false;
                            break;
                    }
                }
                if (b) {
                    map.put(s, map.get(s) + 1);
                }
            }


        }

        int max = 0;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }
        System.out.println(max);


    }

    public static void combination(int s, int count, String sum) {
        if (count == N) {
            map.put(sum, 0);
        }
        for (int i = s; i <= 2 * N; i++) {
            combination(i + 1, count + 1, sum + "/" +i);
        }
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