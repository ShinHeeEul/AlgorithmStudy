import java.util.ArrayList;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= N; i++) res.add(i);
        int count = N;
        System.out.print("<");

        int c = K - 1;
        while(count != 0) {
            while(c >= res.size()) c -= res.size();
            System.out.print(res.remove(c));
            c -= 1;
            count--;
            c+=K;
            if(count > 0) System.out.print(", ");
        }
        System.out.print(">");
    }
}