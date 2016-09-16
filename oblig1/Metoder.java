//Kommentarer paa engelsk incoming, rett og slett lettere. Slitsomt aa maatte tenke paa aa bytte ut ae, oe og aa.
//Oh look, a Scanner import. That means I'm gonna use terminal input.
import java.util.Scanner;

//And a class and main.
class Metoder {
	public static void main (String [] args) {
		//Run the function/method output(), which is what I called the method actually doing stuff in this code.
		output();

		//And added output() two more times, because the task says it needs to ask 3 times.
		output();
		output();
	}

	//New method that contains all the code, as it's gonna be run repeatedly.
	static void output () {
		//Make a scanner.
		//Easiest to make it in this method, as I'm only gonna use it in this method.
		Scanner input = new Scanner(System.in);

		//Ask the user for their name.
		System.out.println("Skriv inn navn:");
		//And accept their input.
		String navn = input.nextLine();
		//Unlike previous classes, error handling with try/except isn't as necessary, as the user will enter a string, and when using nextLine even an empty string is completely fine. No runtime exceptions.

		//And ask the user where they are from
		System.out.println("Skriv inn bosted:");
		//And once again, accept their input.
		String sted = input.nextLine();

		//And again, skip a line to make it look pretty (or prettier at least).
		System.out.println("");
		//Aaaand time to print their name and where they are from.
		System.out.println("Hei, " + navn + "! Du er fra " + sted + ".");
		//And one last time, I like prettifying the output.
		System.out.println("");
	}
}