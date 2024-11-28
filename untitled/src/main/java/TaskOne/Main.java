package TaskOne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        int openBrackets = 0;
        int closeBrackets = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the formula: ");
        String formula = scanner.nextLine();

        //Show only opened and closed brackets
        String onlyBrackets = removeRedundantSymbols(formula);
        System.out.println(onlyBrackets);
        //Convert an onlyBrackets to characters array
        char[] arrChar = onlyBrackets.toCharArray();
        //If there is one symbol the result is 0
        if (arrChar.length == 1) {
            System.out.println(n);
            return;
        }
        //Check: if string contain two symbols and the string start from an opened bracket,
        // and finishing on a closed bracket, the result is 0
        if (arrChar.length == 2 && arrChar[0] == ')' && arrChar[1] == '(') {
            System.out.println(n);
            return;
        }
        //Find an index of a first opened bracket.
        // Incorrect to calculate all closed brackets before the opened bracket.

        int firstIndexOpenedBracket = onlyBrackets.indexOf('(');
        //Find an index of a last closed bracket.
        // Incorrect to calculate all opened brackets after the last closed bracket.
        int lastIndexOfClosedBracket = onlyBrackets.lastIndexOf(')');

        //Calculate quantity of opened and closed brackets.
        for (int i = firstIndexOpenedBracket; i < lastIndexOfClosedBracket + 1; i++) {
            if (arrChar[i] == '(') {
                openBrackets++;
            }
            if (arrChar[i] == ')') {
                closeBrackets++;
            }
        }
        //If quantity of opened and closed brackets equals return sum of one of them( in my case it is a sum of opened brackets)
        if (openBrackets % closeBrackets == 1) {
            System.out.println(openBrackets);
            return;
        }
        //If quantity of opened and closed brackets is different return the smaller of them
        if (openBrackets < closeBrackets) {
            System.out.println(openBrackets);
        } else {
            System.out.println(closeBrackets);
        }

    }

    // Remove redundant symbols from formula. Live only opened and closed brackets.
    static String removeRedundantSymbols(String str) {
        String resultStr = str.codePoints()
                .filter(c -> c == '(' || c == ')')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return resultStr;
    }
}
