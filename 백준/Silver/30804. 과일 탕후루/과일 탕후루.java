import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) arr[i] = read();

        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for(int start = 0, end = 0; end < N ;) {
                map.put(arr[end], map.getOrDefault(arr[end++], 0) + 1);
                while(map.keySet().size() == 3) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    if(map.get(arr[start]) == 0) {
                        map.remove(arr[start]);
                    }
                    start++;
                }

                max = Math.max(max, end - start);
        }
        System.out.println(max);
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