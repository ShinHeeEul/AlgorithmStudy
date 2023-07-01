import java.util.Scanner;

//코드 베낌
// 곱셈
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a = scan.nextInt();
        long b = scan.nextInt();
        long c = scan.nextInt();

        System.out.println(dfs(a, b, c));
    }

    private static long dfs(long a, long n, long c) {
        if (n == 1) {
            return a % c;
        } else if (n % 2 == 0) {
            var y = dfs(a, n/2, c);
            return (y * y) % c;
        } else {
            var y = dfs(a, (n - 1)/2, c);
            return ((y * y) % c * a) % c;
        }
    }
}