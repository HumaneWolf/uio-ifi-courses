class NegativeTall {
	public static void main (String [] args) {
		//Defining the array given in the task.
		int[] heltall = {1, 4, 5, -2, -4, 6, 10, 3, -2};
		//Making a counter for the loop, counting the number of times it has run.
		int c = 0;

		//Make a counter integer for the number of negative numbers, used and changed in the loop.
		int negatives = 0;

		//Print a header for the array to the terminal, before we start going through the values.
		System.out.println(" INDEX          VALUE");
		System.out.println("-----------------------");

		//Run a while loop for a number of times equal to the number of elements in the array.
		while (c < heltall.length) {
			//If the number in the array is less than 0, negative.
			if (heltall[c] < 0) {
				//Increase the number of negatives by 1, this triggers only if the number is less than 0.
				negatives++;

				//Replace the number with their array index.
				//The c counter is equal to the array index, both start from 0 and count up.
				heltall[c] = c;
			}

			//Print the index and the content of that index to the terminal.
			System.out.println("  " + c + "              " + heltall[c]);

			//Increase the run count "c" by 1.
			c++;
		}
		//After the loop, print the number of negative numbers in the terminal.
		System.out.println("Det er " + negatives + " negative tall i arrayen.");
	}
}