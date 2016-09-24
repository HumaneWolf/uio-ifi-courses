//Importing the scanner
import java.util.Scanner;

class EnkelKalkulator {
	public static void main (String [] args) {
		//Making a scanner object we can utilize in our function.
		Scanner input = new Scanner(System.in);

		//Define an array for 2 integers, int 1 and 2.
		//I'm defining it here so that it's available in all of main().
		int[] tall = new int[2];

		//Instructions
		System.out.println("Fyll inn det forste heltallet.");

		//Adding a try/catch for simple error handling, rather than runtime errors if someone tries to do j + x.
		try {
			tall[0] = Integer.parseInt(input.nextLine());
		} catch (java.lang.NumberFormatException e) {
		//java.lang.NumberFormatException is the error that occurs when someone enters anything but an int and the Integer.parseInt function tries to parse it.
			//Giving an error if need be.
			System.out.println("ERROR: Pass paa at du fyller inn et gyldig heltall.");
			//And exit the program. Return ends the function/method, and in this case the function is main(), which the entire program depends on.
			return;
		}

		//And more instructions.
		System.out.println("Fyll inn det andre heltallet.");

		//And repeating the same try/catch for the second number.
		try {
			tall[1] = Integer.parseInt(input.nextLine());
		} catch (java.lang.NumberFormatException e) {
			//Same again, give an error and quit the program.
			System.out.println("ERROR: Pass paa at du fyller inn et gyldig heltall.");
			return;
		}

		//Call the functions/methors to calculate and return results.
		sum(tall[0], tall[1]);
		diff(tall[0], tall[1]);
		prod(tall[0], tall[1]);
	}

	//Function for the sum of two integers. Plus.
	static void sum (int tall1, int tall2) {
		//Pring a line saying what the program did, and add the result.
		System.out.println("Sum: " + (tall1 + tall2));
	}

	//And a function for the difference between two integers. Minus.
	static void diff (int tall1, int tall2) {
		System.out.println("Differanse: " + (tall1 - tall2));
	}

	//Last but not least, function for the product when multiplying two integers.
	static void prod (int tall1, int tall2) {
		System.out.println("Produkt: " + (tall1 * tall2));
	}
}