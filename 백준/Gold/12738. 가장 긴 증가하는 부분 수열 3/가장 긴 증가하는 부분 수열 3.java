import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nn = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nn[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int a = nn[i];
            int size = list.size();
            if(size == 0) {
                list.add(a);
                continue;
            }
            if(list.get(size-1) < a) {
                list.add(a);
            }
            else {
                int start = 0;
                int end = size-1;
                while(start < end) {
                    int mid = (start + end) >>> 1;
                    int aa = list.get(mid);
                    if(a > aa) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                list.set(end, a);
            }
        }

        System.out.println(list.size());
    }
}
