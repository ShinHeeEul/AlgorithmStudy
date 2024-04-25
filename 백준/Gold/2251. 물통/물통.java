import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = read();
        int B = read();
        int C = read();
        int[] max = {A,B, C};

        LinkedHashSet<Integer> answer=  new LinkedHashSet<>();

        Stack<Node> stack = new Stack<>();
        Node start = new Node(new int[]{0,0,C});
        HashMap<String, Boolean> map = new HashMap<>();
        stack.push(start);

        while(!stack.isEmpty()) {
            Node node = stack.pop();

            if(node.current[0] == 0) {
                answer.add(node.current[2]);
            }

            for(int i = 0; i < 3; i++) {
                int crt = node.current[i];
                if(crt == 0) {
                    continue;
                }
                for(int j = 0; j < 3; j++) {
                    if(i == j) continue;


                    int[] aa = node.current.clone();
                    int dif = Math.min(crt, max[j] - node.current[j]);
                    aa[i] = aa[i] - dif;
                    aa[j] = aa[j] + dif;
                    String s = aa[0] + "/" + aa[1] + "/" + aa[2];
                    if(map.getOrDefault(s, false)) {
                        continue;
                    }
                    map.put(s, true);

                    stack.push(new Node(aa));
                }
            }


        }

        answer.stream().sorted().forEach(x -> System.out.print(x + " "));
    }

    static class Node{
        int[] current;
        public Node(int[] current) {
            this.current = current.clone();
        }
    }


    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}