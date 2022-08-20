import java.io.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        String S = br.readLine();
        while(S != null) {
            System.out.println(S);
            S = br.readLine();
        }




        bw.flush();
        br.close();
        bw.close();
    }
}