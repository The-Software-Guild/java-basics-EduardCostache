import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {

        String dogName;

        System.out.println("What is you dog's name?");
        dogName = getUserDogName();

        System.out.println("Well then, I have this highly reliable report on "+dogName+"'s prestigious background right here.");
        System.out.println();
        System.out.println(dogName + " is:");
        System.out.println();

        generateAndPrintGenetics();

        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");

    }

    private static void generateAndPrintGenetics()
    {
        String[] dogBreeds = {"Bulldog", "Labrador Retriever", "German Shepherd", "Poodle", "Golden Retriever", "French Bulldog", "Boxer"};
        Random rng = new Random();
        int percentRemaining = 100;
        int currentPercentage;
        int randomDog;
        int upperBound;
        String dogName;

        for(int i = 0; i<5; i++)
        {
            if(i == 4)
            {
                currentPercentage = percentRemaining;
            }
            else
            {
                upperBound = (int)(percentRemaining * 0.2); // find 20% of the percent remaining
                currentPercentage = rng.nextInt(percentRemaining - upperBound)+1; // use upperBound to search for numbers within a 0.8 range of the remaining percent
                if (i == 3)                                                             // doesn't allow random to generate a value like 99% on the first hit for example.
                {
                    currentPercentage += 1; // Make sure to add 1 so that the minimum value of the 4th dog is 2%. Allows for the 5th dog to be 1% min, and not 0%
                }
                percentRemaining -= currentPercentage;
            }

            do // loop through the dog breed names array until we find one that isn't taken and use that
            {
                randomDog = rng.nextInt(dogBreeds.length);
                dogName = dogBreeds[randomDog];
            }
            while(dogName.equals(""));

            dogBreeds[randomDog] = "";

            System.out.printf("%d%% %s%n", currentPercentage, dogName);
        }
    }

    private static String getUserDogName()
    {
        try
        {
            Scanner in = new Scanner(System.in);
            return in.nextLine();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Error! Try another name.");
            System.exit(1);
            return null;
        }
    }
}
