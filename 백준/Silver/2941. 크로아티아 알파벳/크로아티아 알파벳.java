import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter out = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(out);

        String S = br.readLine();

        int sum = 0;
        for(int i = 0; i < S.length(); i++) {
            switch(S.charAt(i)) {
                case 'c':
                    if(i+1 < S.length()) {
                        if(S.charAt(i + 1) == '=') {
                            sum++;
                            i++;
                            break;
                        }
                        else if(S.charAt(i+1) == '-') {
                            sum++;
                            i++;
                            break;
                        }
                    }
                    sum++;
                    break;
                case 'd':
                    if(i+2 < S.length()) {
                        if(S.substring(i + 1, i + 3).equals("z=")) {
                            sum++;
                            i+= 2;
                            break;
                        }
                    }
                    if(i+1 < S.length()) {
                        if (S.charAt(i + 1) == '-') {
                            sum++;
                            i++;
                            break;
                        }

                    }
                    sum++;
                    break;
                case 'l':
                    if(i+1 < S.length()) {
                        if (S.charAt(i + 1) == 'j') {
                            sum++;
                            i++;
                            break;
                        }
                    }
                    sum++;
                    break;
                case 'n':
                    if(i+1 < S.length()) {
                        if (S.charAt(i + 1) == 'j') {
                            sum++;
                            i++;
                            break;
                        }
                    }
                    sum++;
                    break;
                case 's':
                    if(i+1 < S.length()) {
                        if (S.charAt(i + 1) == '=') {
                            sum++;
                            i++;
                            break;
                        }
                    }
                    sum++;
                    break;
                case 'z':
                    if(i+1 < S.length()) {
                        if (S.charAt(i + 1) == '=') {
                            sum++;
                            i++;
                            break;
                        }
                    }
                    sum++;
                    break;
                default:
                    sum++;
            }
        }

        bw.write(sum + "");

        bw.flush();
        br.close();
        bw.close();
    }
}