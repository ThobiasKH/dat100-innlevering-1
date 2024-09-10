package no.hvl.dat100;


import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class O1 {
    static int[] grades;
    static int gradeSum;
    static int gradeAverage;
    static int numStudents;
    public static void main(String[] args) {
        setNumStudents();
        grades = new int[numStudents];
        System.out.println(numStudents);
        
        for (int i = 0; i < numStudents; i++) {
            addGrade(i);
            String currentStudentGradeMessage = "Elev #" + (i + 1) + " fikk karakter: " + gradePointToCharacter(grades[i]); 
            showMessageDialog(null, currentStudentGradeMessage);
            gradeSum += grades[i];
        }
        gradeAverage = gradeSum / numStudents;

        showMessageDialog(null, "Gjennomsnittskarakteren var " + gradeAverage + "/100 = " + gradePointToCharacter(gradeAverage));

    }

    public static char gradePointToCharacter(int grade) {
        // Denne metoden tar aldri nore utenfor range 0-100 så det. 
        // Viss en klarer å få under 0 poeng er karakter 'F' mer en fortjent
        if      (grade >= 90) return 'A';
        else if (grade >= 80) return 'B';
        else if (grade >= 60) return 'C';
        else if (grade >= 50) return 'D';
        else if (grade >= 40) return 'E';

        return 'F';
    }

    // Det som er irreterande implementasjonen av desse metodane er at du ikkje kan kanselere programmet med å trykke cancel på input-en
    // men det står ikkje noke om at programmet skal være enkelt å gå ut av
    // Det blir også veldig vannsklig å legge inn noe ugyldig med denne implementasjonen
    public static void setNumStudents() {
        boolean validInput = false;

        while (!validInput) {
            String studentAmount = showInputDialog("Legg inn mengden elever som heltal: ");
            try {
                int studentAmountAsInt = Integer.parseInt(studentAmount);
                if (studentAmountAsInt <= 0) {
                    showMessageDialog(null, "Mengden elever kan ikke være under 1");
                } 
                else {
                    numStudents = studentAmountAsInt;
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Vennligst legg inn mengden elever som heltall under 2147483647");
            }
        }
    }

    public static void addGrade(int index) {
        boolean validInput = false;

        while (!validInput) {
            String grade = showInputDialog("Karakteren (heltal 0-100) til elev #" + (index + 1) + ": ");
            try {
                int gradeAsInt = Integer.parseInt(grade);
                if (gradeAsInt < 0 || gradeAsInt > 100) {
                    showMessageDialog(null, "Karakteren til eleven må være et heltal fra 0 til 100");
                } 
                else {
                    grades[index] = gradeAsInt;
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Karakteren til eleven må være et heltal fra 0 til 100");
            }
        }
    }
}

