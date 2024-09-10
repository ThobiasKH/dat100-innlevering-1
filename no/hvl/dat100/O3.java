package no.hvl.dat100;

import java.math.BigInteger;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class O3 {
    // Vi må ha denne variabelen fordi med long (64-bit) kan vi regne ut maksimum 20! som er rundt 2 * 10^8 når long.MAX_VALUE = 9 * 10^8
    // Vi kan bruke math biblioteket sin bigint
    static final long largestFactorialInput = 200;

    public static void main(String[] args) {
        while (true) { 
            int x = getNum();
            boolean useRecursion = Math.random() > 0.5;

            long xF = useRecursion ? factorialR(x) : factorial(x);
            // BigInteger xF = bigFactorial(x);

            showMessageDialog(null, x + "! = " + xF);

            String quit = showInputDialog("Vil du avslutte programmet? (y = ja): ").toLowerCase();

            if (quit.equals("y")) break;

        }
    }



    // med for loop. mer minnebruk med long, men vi kan legge inn større verdier
    static long factorial(long num) {
        if (num <= 0) return 0;
        long sum = 1;
        for (long i = num; i >= 2; i--) {
            sum *= i; 
        }
        return sum;
    }

    static long factorialR(long num) {
        if (num == 1) return 1;
        if (num <= 0) return 0;

        return num * factorialR(num - 1);
    }

    // Her er en måte vi kan regne ut større verdier
    // Litt omhu må sikkert brukes for å kunne handtere bruken av denne metoden
    // Når eg prøvde den ut fikk eg litt problem men det kunne vert mulig
    static BigInteger bigFactorial(int num) {
        BigInteger sum = BigInteger.ONE;
        for (int i = num; num >= 2; i--) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;

    }

    static int getNum() {
        boolean validInput = false;

        while (!validInput) {
            String num = showInputDialog("Legg inn et positivt heltal: ");
            try {
                int numAsInt = Integer.parseInt(num);
                if (numAsInt <= 0) {
                    showMessageDialog(null, "Talet kan ikke være like eller under 0");
                } 
                else if (numAsInt > largestFactorialInput) {
                    showMessageDialog(null, "Denne kalkulatoren kan ikke regne ut n fakultet for n > " + largestFactorialInput);
                }
                else {
                    return numAsInt;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Vennligst legg inn et POSITIVT heltall under " + largestFactorialInput);
            }
        }

        return 0;
    }
}
