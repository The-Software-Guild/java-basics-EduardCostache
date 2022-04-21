import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {

        double maxHeartRate;
        int userAge;

        System.out.println("What is your age?");
        userAge = getUserAge();

        maxHeartRate = 220 - userAge;

        System.out.printf("Your maximum heart rate should be %.0f beats per minute%n", maxHeartRate);
        System.out.printf("Your target HR Zone is %.0f - %.0f beats per minute", maxHeartRate * 0.5, maxHeartRate * 0.85);
    }

    private static int getUserAge()
    {
        try
        {
            Scanner in = new Scanner(System.in);
            int input = Integer.parseInt(in.nextLine());
            if (input < 0) {
                exitProgram();
                return 0;
            }
            else {
                return input;
            }
        }
        catch(NumberFormatException e)
        {
            exitProgram();
            return 0;
        }
    }

    private static void exitProgram()
    {
        System.out.println("Error with age! Try again!");
        System.exit(1);
    }
}
