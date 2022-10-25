//10_10_2022 Pedro Marín Sanchis

//This program calculates the golden number using the fibonacci sequence.

public class Java_Basico_EJ41 {

    public static void main(String[] args) {

        //Declare variables

        float n1 = 1;
        float n2 = 1;
        float t = 0;
        String goldenNumberAprox = "Aproxiamtions for the golden number are: ";
        
        //Calculate

        System.out.println("The first 40 numbers of the fibonacci sequence are: 1, 1");

        for (int i = 3; i <= 40; i++) {

            t = n1 + n2;
            goldenNumberAprox = goldenNumberAprox + (t / (n2-1)) + ", ";
            n1 = n2;
            n2 = t;
            System.out.print(", " + t);

        }

        System.out.print(".\n");
        System.out.println(goldenNumberAprox);

    }

}