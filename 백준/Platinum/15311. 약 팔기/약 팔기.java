public class Main {
    public static void main(String[] args) throws Exception{
        read();
        String s = "";
        for(int i = 0; i < 1000; i++) s += 1 + " ";
        for(int i = 0; i < 1000; i++) s += 1000 + " ";
        System.out.println(2000);
        System.out.println(s);
    }
    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }
}