package no.hvl.dat100;


import static javax.swing.JOptionPane.*;
public class O2 {


    public static void main(String[] args) {
        int salary = getUserInputSalary();
        System.out.println("Bruttolønn: " + salary + "kr");
        int trinnskatt = getTrinnSkatt(salary);
        System.out.println("Trinnskatt å betale: " + trinnskatt + "kr");
    }

    public static int getUserInputSalary() {
        int salaryAsInt = 0;
        boolean validInput = false;

        // Ingenting stopper brukeren fra å legge inn negativ lønn, men eg ser ikkje på det som et problem
        // Det står ingenting i oppgaveteksten om at vi skal stoppe brukeren fra å gjøre det
        while (!validInput) {
            String salary = showInputDialog("Skriv inn årslønn som eit heiltal:");
            try {
                salaryAsInt = Integer.parseInt(salary);
                validInput = true;
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Feil input, prøv igjen");
            }
        }

        return salaryAsInt;
    }

    public static int getTrinnSkatt(int salary) {
        // Kunne brukt lower bound <= salary && salary <= upperbound, men eg bestemte meg for å abstrahere det ut til egen metode for ingen god grunn
        if (isBetween(salary, 208051, 292850)) {
            return (int) (salary * 0.017);
        }
        else if (isBetween(salary, 292851, 670000)) {
            return (int) (salary * 0.04);
        }
        else if (isBetween(salary, 670001, 937900)) {
            return (int) (salary * 0.136);
        }
        else if (isBetween(salary, 937901, 1350000)) {
            return (int) (salary * 0.166);
        }
        else if (isBetween(salary, 1350001, Integer.MAX_VALUE)) {
            // Veldig rar måte å gjør det på egentlig
            // Her kan vi ha salary >= 1350001.
            // Tenkte det var ok med Integer.MAX_VALUE
            // Salary går antagligvis til de negative tallene.
            // Hadde gitt mer mening om vi brukte long siden en multi-milliardær ville gått over Integer max verdien på rundt 2 milliarder
            return (int) (salary * 0.176);
        }
        return 0;
    }

    // unødvendig metode, men følte for å gjør det uansett
    static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
} 

