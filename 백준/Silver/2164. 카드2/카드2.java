import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N+1; i++) queue.add(i);

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.remove());
        }

        System.out.println(queue.remove());

    }
}