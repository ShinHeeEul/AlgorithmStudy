import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken()).add(BigInteger.ONE);


        System.out.println(calculate(B).subtract(calculate(A)));
    }

    static BigInteger calculate(BigInteger B) {

        BigInteger answerB = BigInteger.ZERO;
        answerB = answerB.add(B.divide(BigInteger.TWO));

        if(B.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }

        int i;
        for(i = 2; B.compareTo(BigInteger.TWO.pow(i)) >= 0; i++) {

            BigInteger current = BigInteger.TWO.pow(i);
            BigInteger q = B.divide(current);
            BigInteger mod = B.mod(current);


            answerB = answerB.add(q.multiply(current.divide(BigInteger.TWO)));
            BigInteger tmp = mod.subtract(current.divide(BigInteger.TWO));
            if(tmp.compareTo(BigInteger.ZERO) > 0) {
                answerB = answerB.add(tmp);
            }
        }

        BigInteger mod = B.mod(new BigInteger(BigInteger.TWO.pow(i-1) + ""));

        return answerB.add(mod);
    }
}
