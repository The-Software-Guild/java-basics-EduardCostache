import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static int computerWins, draws, playerWins, maxRounds = 0;

    public static void main(String[] args) {
        while(true)
        {
            computerWins = 0;
            playerWins = 0;
            draws = 0;

            System.out.println("How many rounds do you want to play?");
            maxRounds = getPlayerRounds();
            System.out.println();

            if (maxRounds != 0)
            {
                int playerChoice = 0;
                int computerChoice;
                for (int i = 1; i<=maxRounds; i++)
                {
                    boolean validChoice = false;
                    System.out.printf("*********Round %d*********%n", i);

                    while(!validChoice)
                    {
                        System.out.println("Choose an option: (1=rock, 2=paper, 3=scissors)");
                        playerChoice = getPlayerChoice();
                        validChoice = playerChoice != 0;
                    }

                    computerChoice = getComputerChoice();
                    System.out.printf("Computer Chose: %s%n", parseChoice(computerChoice));

                    decideWinner(playerChoice, computerChoice);
                }

                System.out.println();
                System.out.println("-----------GAME OVER-----------");
                System.out.printf("Player Wins: %d%n", playerWins);
                System.out.printf("Computer Wins : %d%n", computerWins);
                System.out.printf("Draws: %d%n", draws);

                System.out.println("Do you want to play again? (y/n)");
                if (!getPlayerAnswer())
                {
                    System.out.println(".........................");
                    System.out.println("Thanks for playing! Bye!");
                    System.out.println(".........................");
                    break;
                }
            }
        }

    }

    private static void decideWinner(int playerChoice, int computerChoice)
    {
        // rock = 1
        // paper = 2
        // scissors = 3

        if(computerChoice == 1) {
            if (playerChoice == 2) {
                playerWins++;
                System.out.println("The Player WINS!");
                System.out.println();
            }
            else if(playerChoice == 3) {
                computerWins++;
                System.out.println("The Computer WINS!");
                System.out.println();
            }
            else {
                draws++;
                System.out.println("It's a DRAW!");
                System.out.println();
            }
        }
        else if(computerChoice == 2){
            if (playerChoice == 1) {
                computerWins++;
                System.out.println("The Computer WINS!");
                System.out.println();
            }
            else if(playerChoice == 3) {
                playerWins++;
                System.out.println("The Player WINS!");
                System.out.println();
            }
            else {
                draws++;
                System.out.println("It's a DRAW!");
                System.out.println();
            }
        }
        else if (computerChoice == 3) {
            if (playerChoice == 1) {
                computerWins++;
                System.out.println("The Computer WINS!");
                System.out.println();
            }
            else if(playerChoice == 2) {
                playerWins++;
                System.out.println("The Player WINS!");
                System.out.println();
            }
            else {
                draws++;
                System.out.println("It's a DRAW!");
                System.out.println();
            }
        }
    }

    private static int getComputerChoice()
    {
        Random random = new Random();
        return random.nextInt(3)+1;
    }

    private static boolean getPlayerAnswer()
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        return input.equals("y");
    }

    private static int getPlayerChoice()
    {
        // 0 = fail
        // 1 = rock
        // 2 = paper
        // 3 = scissors
        try
        {
            Scanner in = new Scanner(System.in);
            int input = Integer.parseInt(in.nextLine());

            if(input == 1 || input == 2 || input == 3)
            {
                return input;
            }
            else
            {
                return 0;
            }
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    private static int getPlayerRounds()
    {
        // 0 = fail
        try
        {
            Scanner in = new Scanner(System.in);
            int input = Integer.parseInt(in.nextLine());

            if(input >= 1 && input <= 10)
            {
                return input;
            }
            else
            {
                return 0;
            }
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    private static String parseChoice(int choiceNumber)
    {
        if (choiceNumber == 1) {
            return "Rock";
        }
        else if(choiceNumber == 2) {
            return "Paper";
        }
        else if(choiceNumber == 3) {
            return "Scissors";
        }
        else {
            return null;
        }
    }
}