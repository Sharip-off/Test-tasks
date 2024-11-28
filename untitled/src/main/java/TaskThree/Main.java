package TaskThree;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        //Convert a BigInteger into a String
        String factorial = getFactorial(100).toString();

        for (int i = 0; i < factorial.length(); i++) {
            //factorial.charAt(i) - '0' convert char into int
            sum += factorial.charAt(i) - '0';
        }
        System.out.println(sum);

    }
    //Find a factorial
    public static BigInteger getFactorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= number; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
}
