//16_10_2022 Pedro Marín Sanchis

import java.util.Scanner;

public class Metodos_EJ3 {

    public static void CalculateGrade(float grade) {

        String writtenGrade = "sin calcular";

            if (grade <= 10) {

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

    }

    public static void main(String[] args) {
    
        float grade = 0;
    
        //Reading the grade
    
        System.out.println("Escribe la nota:");
        
        Scanner inputValue;
        inputValue = new Scanner(System.in);
        grade = inputValue.nextFloat();


        //Calculate written result

        CalculateGrade(grade);
        inputValue.close();
        
    }

}
