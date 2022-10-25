//05_10_2022 Pedro Marín Sanchis

//This program calculates the fibonacci sequence.

public class Java_Basico_EJ40 {

    public static void main(String[] args) {

        //Declare variables

        int n1 = 1;
        int n2 = 1;
        int t = 0;
        
        //Calculate

        System.out.println("The first 40 numbers of the fibonacci sequence are: 1, 1");

        for (int i = 3; i <= 40; i++) {

            t = n1 + n2;
            n1 = n2;
            n2 = t;
            System.out.print(", " + t);

        }

        System.out.print(".\n");

    }

}