/*
Jeg lager et enkelt program som laster inn mulige retter fra en meny (i en tekstfil), og foreslaar en tilfeldig rett.
*/
//Importing the scanner and a file reading utility.
import java.util.Scanner;
import java.io.File;
//Importing a random number generating utility.
import java.util.Random;

class MinOppgave4 {
	public static void main(String[] args) throws Exception {
		String dish = getFoodz();
		System.out.println(" - Saa, hva vil du ha til middag?");
		System.out.println(" - Hva med " + dish + "!");
	}

	static String getFoodz() throws Exception {
		//Making a file object, loading the file itself.
		File fileObj = new File("foodz.txt");
		//And a file scanner (not a terminal one).
		Scanner file = new Scanner(fileObj);
		//And a second scanner that I use to count the number of lines the file has.
		Scanner fileLines = new Scanner(fileObj);
		//Making a random object to generate the random number.
		Random random = new Random();

		//Counting the number of lines in a file before I create the array to store the food in.
		int numberOfLines = 0;
		//While the file has more lines.
		while (fileLines.hasNextLine()) {
			//Count the lines
			numberOfLines++;
			//And load the next line.
			fileLines.nextLine();
		}
		
		//Then make an array with the correct amount of indexes.
		String[] foodList = new String[numberOfLines];

		//While there are more lines to load, load them into the array. Using a for loop because I have the number of lines the file has already, and I need the index anyway to add them to the array.
		for (int i = 0; i < numberOfLines; i++) {
			//And adding the nextline to the array.
			foodList[i] = file.nextLine();
		}
		// Generate a random number: nextInt(Highest possible number);
		int randomNum = random.nextInt(numberOfLines );
		//And return a dish based on the food entered. Minus 1 because arrays start from 0
		return foodList[randomNum];
	}
}