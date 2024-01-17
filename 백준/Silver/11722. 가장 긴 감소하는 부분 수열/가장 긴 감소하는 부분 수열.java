import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {

        int N = read();
        int[] arr = new int[N];
        int[] list = new int[N];
        int size = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = read();
            int a = arr[i];

            if(size == 0) {
                list[size++] = a;
                continue;
            }
            int b = list[size - 1];
            if(b > a) {
                list[size++] = a;
            } else if(b < a) {
                int start = 0;
                int end = size;
                while(start < end) {
                    int mid = (start + end) / 2;

                    int tmp = list[mid];
                    if(tmp > a) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                list[end] = a;
            }
        }

        System.out.println(size);

    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}
