//22_09_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Java_Basico_EJ14 {

    public static void main(String[] args) {
    
        float grade = 0;
        String writtenGrade = "sin calcular";
    
        //Reading the grade
    
        System.out.println("Escribe la nota:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        grade = inputValue.nextFloat();


        //Calculate written result

        if (grade < 10) {

        writtenGrade = "Sobresaliente.";

        }

        if (grade < 9) {

        writtenGrade = "Notable.";

        }
        
        if (grade < 7) {

        writtenGrade = "Bien.";

        }
        
        if (grade < 6) {

        writtenGrade = "Suficiente.";

        }
        
        if (grade < 5) {

        writtenGrade = "Insuficiente.";

        }

        if (grade < 3) {

        writtenGrade = "Muy Deficiente.";

        }

        //Display results
       
        System.out.println("Tu nota es: " + grade + ", " + writtenGrade);
        inputValue.close();
        
    }

}
