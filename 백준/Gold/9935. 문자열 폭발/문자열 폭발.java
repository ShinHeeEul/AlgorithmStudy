import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String Bum = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
            boolean b = true;
            if(stack.size() >= Bum.length()) {
                for(int j = 0; j < Bum.length(); j++) {
                    if(stack.get(stack.size() - Bum.length() + j) != Bum.charAt(j)) {
                        b = false;
                        break;
                    }
                }
                if(b) {
                    for(int j = 0; j < Bum.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();

        for(Character c : stack) {
           sb.append(c);
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }

    private static int read() throws Exception {
        int d, o;
        boolean negative = false;
        d = System.in.read();
        if (d == 45) {
            negative = true;
            d = System.in.read();
        }

        o = d & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);

        return negative ? -o : o;
    }
}