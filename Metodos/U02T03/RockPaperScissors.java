// 19/11/2022 Pedro Marín Sanchis

// This program lets you play Hand, Paper, Scissors!

import java.util.Scanner;

public class RockPaperScissors {

    // Options

    final static boolean announceCPUChoice = true;
    
    // Statistics

    static int gamesWon = 0;
    static int gamesLost = 0;
    static int gamesTied = 0;

    static int rocksPlayed = 0;
    static int papersPlayed = 0;
    static int scissorsPlayed = 0;
    
    // Enemy logic variables

    static int lastCPUChoice = 1;
    static boolean lastGameCPULost = false;

    public static String showStatistics() {
        
        return ("STATISTICS\nGames won: " + gamesWon + "\nGames lost: " + gamesLost + "\nGames tied: " + gamesTied + "\nTotal games played: " + (gamesLost + gamesWon + gamesTied) + "\nTimes you played rock: " + rocksPlayed + "\nTimes you played paper: " + papersPlayed + "\nTimes you played scissors: " + scissorsPlayed);

    }

    public static int calculateWinner(int playerChoice, int cpuChoice) { // 0 = Player Win, 1 = CPU Win, 2 = Tie
        
        if (announceCPUChoice) {announceCPUChoice(cpuChoice);}
        
        if (playerChoice == cpuChoice) {System.out.println("This game is a Tie!"); gamesTied++; return 2;}
        
        switch (playerChoice) { // Convention: 0 = Rock, 1 = Paper, 2 = Scissors

            case 1:
                if (cpuChoice == 2) {System.out.println("You loose."); gamesLost++; return 1;}
            break;

            case 2:
                if (cpuChoice == 3) {System.out.println("You loose."); gamesLost++; return 1;}
            break;

            case 3:
                if (cpuChoice == 1) {System.out.println("You loose."); gamesLost++; return 1;}
            break;

        }
        
        System.out.println("You win!");
        gamesWon++;
        return 0;

    }


    public static void announceCPUChoice(int cpuChoice) { // Announce CPU choice, depends on announceCPUChoice flag.

        switch (cpuChoice) {

            case 1:
                System.out.println("The CPU chose Rock."); 
            break;

            case 2:
                System.out.println("The CPU chose Paper."); 
            break;

            case 3:
                System.out.println("The CPU chose Scissors."); 
            break;

        }
    
    }


    public static int enemyLogic() {

        int choice = 0;

        if (gamesLost + gamesWon + gamesTied == 0) {return 2;} // Most players start with Rock!

        if ((int) (Math.random()*3+1) == 1) { // Random chance of random choice.

            switch ((int) (Math.random()*3+1)) {

                case 1:
                    choice = 2;
                break;
    
                case 2:
                    choice = 3;
                break;
    
                case 3:
                    choice = 1;
                break;

            }

        }

        if (gamesLost + gamesWon != 0 & lastGameCPULost == false & lastCPUChoice != 0) { // Tries to predict next player choice after a player loss (They tend to change to what would have won last round!)

            switch (lastCPUChoice) {

                case 1:
                    choice = 2;
                break;
    
                case 2:
                    choice = 3;
                break;
    
                case 3:
                    choice = 1;
                break;

            }

        }

        lastCPUChoice = choice;
        return choice;

    }


    public static void main(String[] args) {

        // Declare variables

        int choice = 0;
        boolean correctInputFlag = false;

        Scanner inputValue; // Open Scanner
        inputValue = new Scanner(System.in);

        // Main program loop

        while (true) {

            correctInputFlag = false; // Reset condition

            if (gamesLost + gamesWon + gamesTied == 0) { // Different message for program startup

                System.out.print("Play 'Rock, Paper, Scissors'? 0 = No, 1 = Yes: ");

            } else {

                System.out.print("Keep playing? 0 = No, 1 = Yes: ");

            }

            choice = inputValue.nextInt(); // Read Player choice

            if (choice == 0) {break;} // Exit condition.

            while (correctInputFlag == false) {

                System.out.print("Make your choice [Rock: 1, Paper: 2, Scissors: 3]: "); // Ask for player choice [We assume inputs are valid]
                choice = inputValue.nextInt();

                switch (choice) {

                    case 1:
                        calculateWinner(choice, enemyLogic());
                        rocksPlayed++;
                        correctInputFlag = true;
                    break;
                    
                    case 2:
                        calculateWinner(choice, enemyLogic());
                        papersPlayed++;
                        correctInputFlag = true;
                    break;

                    case 3:
                        calculateWinner(choice, enemyLogic());
                        scissorsPlayed++;
                        correctInputFlag = true;
                    break;

                    default:
                        System.out.println("Wrong input!");
                        break;

                }
            
            }

        }

        System.out.println("Show statistics? 0 = No, 1 = Yes: ");
        choice = inputValue.nextInt();
        if (choice == 1) {System.out.println(showStatistics());}

        inputValue.close(); //Close Scanner

    }

}