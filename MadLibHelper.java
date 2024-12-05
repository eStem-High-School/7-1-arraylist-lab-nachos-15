import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This is a command line utility for generating random nouns, verbs, adverbs
 * etc.
 * 
 * @author Nathan Sprague
 * @version 3/30/2015
 *
 */
public class MadLibHelper
{
    /**
     * The main loads a POSDictionary, then interacts with the user through the
     * terminal.
     * 
     * @param args arg[0] should be a filename containing the dicionary
     */
    public static void main(String[] args)
    {
        Scanner scanner;
        String userInput;
        POSDictionary posDict;
        try
        {

            posDict = new POSDictionary("pos_dict.txt");
            scanner = new Scanner(System.in);

            System.out.println("Welcome to MadLib Helper!");
            System.out.println("Enter: ");
            System.out.println("  'N' for a noun\n  'V' for a verb\n"
                    + "  'A' for an adjective\n  'v' for an adverb");
            System.out.println("Press Ctrl-D to quit.");
            while (scanner.hasNextLine())
            {
                userInput = scanner.nextLine().trim();
                switch (userInput)
                {
                    case "N":
                        System.out.println(posDict.randomNoun());
                        break;
                    case "V":
                        System.out.println(posDict.randomVerb());
                        break;
                    case "A":
                        System.out.println(posDict.randomAdjective());
                        break;
                    case "v":
                        System.out.println(posDict.randomAdverb());
                        break;
                }
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Couldn't open: " + args[0]);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Usage: java MadLibHelper POSFILE");
        }
    }

    public static void playGame(POSDictionary posDict){
        System.out.println("The " + posDict.randomAdjective() + " " + posDict.randomNoun() + " was " + posDict.randomVerb() + " " + posDict.randomAdverb() + " across the " + posDict.randomNoun());
    }

}
