import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int[] arr = new int[N];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            arr[i] = read();
            int a = arr[i];
            int size = list.size();

            if(list.size() == 0) {
                list.add(a);
                continue;
            }
            int b = list.get(size - 1);
            if(b > a) {
                list.add(a);
            } else if(b < a) {
                int start = 0;
                int end = size;
                while(start < end) {
                    int mid = (start + end) / 2;

                    int tmp = list.get(mid);
                    if(tmp > a) {
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


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
