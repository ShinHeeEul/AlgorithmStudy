import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            // 새로들어올 박스의 값보다 더 큰 값이 있다면 pop해주자. 
            while(!deque.isEmpty() && deque.getLast().value > temp) {
                deque.removeLast();
            }
            deque.addLast(new Node(temp, i));
            // 너무 오래되서 빼야할 박스들을 빼는 부분
            if (deque.getFirst().index <= i -l) {
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}