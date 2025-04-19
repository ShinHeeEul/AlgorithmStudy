public class Main {

    public static void main(String[] args) throws Exception {

        int count = 0;
        for(int i = 0; i < 8; i++) {

            for(int j = 0; j < 8; j++) {
                char c = (char) System.in.read();

                if((i + j) % 2 == 0 && c == 'F') count++;
            }
            System.in.read();
        }
        System.out.println(count);
    }

}
