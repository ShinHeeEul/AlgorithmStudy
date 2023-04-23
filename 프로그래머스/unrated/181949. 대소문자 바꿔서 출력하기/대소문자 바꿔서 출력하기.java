import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(char c : a.toCharArray()) {
            int i = (int) c;
            if(i >= 97) i -= 32;
            else i += 32;
            System.out.print((char)i);
        }
    }
}