import java.util.Scanner;
import java.io.File;

class Innlesing {
	public static void main(String[] args) throws Exception{
		//Load the file.
		File fileObj = new File("winnie.txt");
		//And make a scanner for it.
		Scanner file = new Scanner(fileObj);
		//Then let's make an own scanner to allow terminal input.
		Scanner in = new Scanner(System.in);

		System.out.println("Hvilket ord vil du lete etter?");
		//What to search for. Allow terminal input.
		String searchFor = in.nextLine();
		//And how many times it has been found.
		int found = 0;
		//Outside of the loop to make it available in the entire method.

		//Run the loop while the file scanner has another line it can read.
		while(file.hasNextLine()) {
			//If the next line matches what we're searching for.
			//I used equalsIgnoreCase because most likely the user will be searching for how many times a word is used regardless of casing, in other words, they won't care about whether it's an uppercase or a lowercase word.
			if (searchFor.equalsIgnoreCase(file.nextLine())) {
				found++;
			}
		}

		//And print it.
		System.out.println(searchFor + " ble funnet " + found + " ganger.");
	}
}