//Importing the scanner as usual
import java.util.Scanner;

class FirstArray {
	public static void main (String [] args) {
		//Preparing the scanner object.
		Scanner input = new Scanner(System.in);

		//Let's set the max number of ints in the integer array here, since it's used in multiple places. Set as final, because it's never gonna change during runtime.
		final int INT_COUNT = 4;
		//Define an array for my ints.
		int[] intArray = new int[INT_COUNT];
		//And define a variable for how many times a loop has run.
		int intCounter = 0;


		//And behold, the loop itself, in all it's glory.
		//Set to smaller to, since the intcounter starts at 0. This means the 4th time it runs intCounter will be equal 3 (at the start).
		while (intCounter < INT_COUNT) {
			//Since we want to set the numbers to the 0, 1, 2, 3, let's just do this. Whilecounter will start at 0 and count to 3.
			//Then, adding an if/else to set the first and last number to 1337 instead. 0 is first and 3 is last.
			if (intCounter == 0 || intCounter == (INT_COUNT - 1)) {
				intArray[intCounter] = 1337;
			} else {
				intArray[intCounter] = intCounter;
			}
			//Increasing the variable storing the number of times the loops has run. Else it will run forever.
			intCounter++;
		}

		//Define a number of names we are gonna have, since it's used multiple places.
		final int NAME_COUNT = 5;
		//Making an empty string array for those names.
		String[] nameArray = new String[NAME_COUNT];
		//Define a new loop counter for the name input. Same as intCounter.
		int nameCounter = 0;

		//Ask the user to enter some names name.
		System.out.println("Vennligst fyll inn fem navn.");

		//And making the loop itself. Also the same as the loop above.
		while (nameCounter < NAME_COUNT) {
			//Set the name in the relevant index to the user input.
			nameArray[nameCounter] = input.nextLine();
			//Again increasing the loop run counter.
			nameCounter++;
		}

		//And now to the outputs.
		//The integer output could asily have been combined with the loop defining each integer, but for the sake of this task I'll just put it here. It makes it more similar to the runtime example in the task.

		//Printing what is about to be shown to the user:
		System.out.println("Innhold i int-arrayen:");
		//Making an int for how many times the loop has been ran.
		int cInt = 0; //short for Count Integers.
		//And running the loop, just like the while loops above.
		while (cInt < INT_COUNT) {
			//Print the integers, printing the name from the array found using the index identical to the counter variable.
			System.out.println(intArray[cInt]);
			//And increase the counter.
			cInt++;
		}

		//And then doing the same for the names array. Exactly the same as for the int array.
		System.out.println("Innhold (navn) i String-arrayen:");
		int cStr = 0;
		while (cStr < NAME_COUNT) {
			System.out.println(nameArray[cStr]);
			cStr++;
		}
	}
}