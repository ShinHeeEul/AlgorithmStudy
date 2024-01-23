import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = arr.length;
        HashSet<Node>[] dp = new HashSet[size];
        for (int i = 0; i < size; i++) {
            dp[i] = new HashSet<>();
        }

        dp[0].add(new Node(0, 0, 0));

        for (int i = 1; i < size; i++) {
            for (Node n : dp[i - 1]) {
                ArrayList<Node> list = move(n, arr[i - 1]);

                for (Node nn : list) {
                    dp[i].add(nn);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (Node n : dp[size - 1]) {
            if (n.val < min) {
                min = n.val;
            }
        }

        System.out.println(min);
    }

    static ArrayList<Node> move(Node n, int current) {
        int right = n.right;
        int left = n.left;
        int val = n.val;
        ArrayList<Node> list = new ArrayList<>();
        if (left == current || right == current) {
            list.add(new Node(left, right, val + 1));
            return list;
        } else if (right == 0) {
            list.add(new Node(left, current, val + 2));
        } else if (left == 0) {
            list.add(new Node(current, right, val + 2));
        }
        int rightDiff = Math.abs(right - current);
        int leftDiff = Math.abs(left - current);
        if (rightDiff == 1 || rightDiff == 3) {
            list.add(new Node(left, current, val + 3));
        }
        if (leftDiff == 1 || leftDiff == 3) {
            list.add(new Node(current, right, val + 3));
        }
        if (leftDiff == 2) {
            list.add(new Node(current, right, val + 4));
        }
        if (rightDiff == 2) {
            list.add(new Node(left, current, val + 4));
        }

        return list;
    }

    static class Node implements Comparable<Node> {
        int right;
        int left;
        int val;

        public Node(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val - o.val;
        }

        @Override
        public int hashCode() {
            if (left < right) {
                return Objects.hash(left, right);
            } else {
                return Objects.hash(right, left);
            }
        }

        @Override
        public boolean equals(Object obj) {
            Node n = (Node) obj;
            if (n.val > val) {
                n.val = val;
            }
            if (val > n.val) {
                val = n.val;
            }
            return (n.right == right || n.right == left) && (n.left == left || n.left == right);
        }
    }
}
