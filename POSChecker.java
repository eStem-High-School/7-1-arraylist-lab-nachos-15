import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This is a command line utility for checking the part of speech of a word.
 * 
 * @author Nathan Sprague
 * @version 3/30/2015
 *
 */
public class POSChecker
{
    /**
     * The main method loads a POSDictionary, and then interacts with user
     * through the terminal.
     * 
     * @param args - arg[0] should be a filename containing the dicionary
     */
    public static void main(String[] args)
    {
        Scanner scanner;
        String userInput;
        POSDictionary posDict;
        boolean knownPOS;
        try
        {

            posDict = new POSDictionary("pos_dict.txt");
            scanner = new Scanner(System.in);

            System.out.println("Welcome to the POS checker!");
            System.out.println("Enter a word.");
            System.out.println("Press Ctrl-D to quit.");

            while (scanner.hasNextLine())
            {
                userInput = scanner.nextLine().trim();
                knownPOS = false;
                if (posDict.isNoun(userInput))
                {
                    System.out.println("Your word is a noun.");
                    knownPOS = true;
                }
                if (posDict.isVerb(userInput))
                {
                    System.out.println("Your word is a verb.");
                    knownPOS = true;
                }
                if (posDict.isAdjective(userInput))
                {
                    System.out.println("Your word is an adjective.");
                    knownPOS = true;
                }
                if (posDict.isAdverb(userInput))
                {
                    System.out.println("Your word is an adverb.");
                    knownPOS = true;
                }
                if (!knownPOS)
                {
                    System.out.println("I don't have a part of speech for that word.");
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

}
