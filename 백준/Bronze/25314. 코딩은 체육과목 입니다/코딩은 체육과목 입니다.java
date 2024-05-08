
public class Main {
    public static void main(String[] args) throws Exception{
        int N = read();
        StringBuilder sb = new StringBuilder();
        while((N / 4) != 0) {
            N -= 4;
            sb.append("long").append(" ");
        }
        sb.append("int").append(" ");

        System.out.println(sb);
    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;

    }
}