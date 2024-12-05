import java.io.FileNotFoundException;

public class MadLibs{
    public static void main(String[] args){
        POSDictionary posDict;
        try{
            posDict = new POSDictionary("pos_dict.txt");
            MadLibHelper.playGame(posDict);
        }
        catch(FileNotFoundException e){
            System.out.println("Couldn't open: " + args[0]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Usage: java MadLibHelper POSFILE");
        }
    }
}