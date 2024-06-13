import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        int N = read();

        int[] arr = new int[N];
        Stack<Integer>[] stacks = new Stack[4];
        for(int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
            stacks[i].add(0);
        }
        for(int i = 0; i < N; i++) {
            int re = read();
            int min = Integer.MIN_VALUE;
            int minIndex = -1;
            for(int j = 0; j < 4; j++) {
                // 탐색하면서
                // 현재 값보다 작은 값 중 차가 제일 작은 애
                int dif = stacks[j].peek() - re;
                if(dif < 0) {
                    if(min <= dif) {
                        min = dif;
                        minIndex = j;
                    }
                }
            }
            if(min == Integer.MIN_VALUE) {
                System.out.println("NO");
                return;
            }
            stacks[minIndex].push(re);
        }
        System.out.println("YES");


    }

    private static int read() throws Exception {
        int d, o = 0;
        boolean isNegative = false;

        d = System.in.read();
        if (d == 45) {
            isNegative = true;
            d = System.in.read();
        }


        d &= 15;
        o = d;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return isNegative ? -o : o;
    }

}
