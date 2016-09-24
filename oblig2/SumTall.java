//Importing Java Scanner as per usual.
import java.util.Scanner;

class SumTall {
	public static void main (String [] args) {
		//And making an object with the scanner so we can actually use it.
		Scanner input = new Scanner(System.in);

		//Give instructions.
		System.out.println("Fyll inn flere heltall.");
		System.out.println("Fyll inn 0 for å avslutte programmet.");

		//Define some variables. Defined here so they're available outside of the while loop and the try/catch.
		int sum = 0; //Set to 0 so we can do math with it without errors.
		int tall = 1; //Set to 1 so it's not equal to 0, allowing us to start the loop next, rather than asking for an input first.
		//Because we ask for an input before doing any math in the loop, this won't affect the result at all.

		//Make it happen until the user enters the number 0.
		while (tall != 0) {
			//Basic error handling, to avoid runtime errors. Give the user a proper error instead.
			try {
				tall = Integer.parseInt(input.nextLine());
			} catch (java.lang.NumberFormatException e) { //if parseInt fails because the user enters a string this error happens.
				System.out.println("ERROR: Du kan kun fylle inn heltall.");
				//And return, causing the method to end and thus the program to end, because this is main().
				return;
			}

			//Add the entered number to the total sum.
			sum = sum + tall;
		}
		//And print the sum when the loop ends.
		System.out.println("Sum: " + sum);
	}
}