/*
	Lage en kalkulator som kan finne de x foerste primtallene, antallet blir valgt av brukeren.
*/
//Importing the scanner.
import java.util.Scanner;

class MinOppgave3 {
	//Here's the main method.
	public static void main (String [] args) {
		//Making the scanner object so I can use it.
		Scanner input = new Scanner(System.in);
		//Declaring the wantedprimes variable here, because of teh java scopes. I want it avilable in all of main.
		int wantedPrimes;

		//Ask the user to enter the amount of prime numbers they'd like.
		System.out.println("Fyll inn antallet primtall du oensker.");
		System.out.println("NB: Hoye tall kan ta lang tid.");
		//Error handling, allowing me to give my own error rather than a runtime error if the user enters something wrong.
		try {
			//Ask how many primes the user want, accept their input.
			wantedPrimes = Integer.parseInt(input.nextLine());
			//And then we listen for the specific exception that happens if they enter something that can't be parsed as an int.
		} catch (java.lang.NumberFormatException e) {
			//Handle the error: Give a message and quit the program.
			System.out.println("ERROR: Du maa fylle inn et heltall.");
			return;
		}

		//And if the wanted number of primes is below 1
		if (wantedPrimes < 1) {
			//Then tell the user to give a positive number instead.
			System.out.println("ERROR: Du maa fylle inn et positivt tall.");
			return;
		}

		//Declaring the number of primes found, needed for array indexing and loop counters.
		int numOfPrimes = 0;
		//Declaring the array I'm gonna store the prime numbers in.
		int[] primes = new int[wantedPrimes];
		//Declaring the variable storing the current number the script is processing, just like a normal loop counter would. Starting at 2.
		int currentNumber = 2;
		//Declaring a boolean to store the status of each number tested.
		boolean isPrime;
		//Declaring another loop counter for the second loop (loop inside a loop). This will be set during the first loop.
		int i;

		//Making the first loop, looping until we've found enough primes.
		while (numOfPrimes < wantedPrimes) {
			//Default the isPrime variable to true, it will be set to false if the tested number is NOT a prime.
			isPrime = true;
			//Default the second loop counter to a number 1 lower than the current number we're testing, so that we don't test dividing the number by itself. Could be set to divide by 2, but then you need to round it up to get it correct, so for this task I'm doing this simpler solution.
			i = currentNumber - 1;
			//Making the second loop, checking if you can divide the currentNumber by anything and get a whole number. Bigger than 1, because we can divide everything by 1.
			while (i > 1) {
				/* I am using the "remainder" sign, or % - For "currentNumber % i"This tries to do the division I give it, but returns how much is left if it stops dividing into decimal numbers. If this is 0, then that means currentNumber can be divided by i, which means currentNumber is NOT a prime. If no division gives a remainder of 0, this means the number is a prime number.
				The remainder operator is also refered to as Modula/modulus in some languages. */
				if ((currentNumber % i) == 0) {
					//If it is not a prime, set the isPrime variable to false.
					isPrime = false;
					//Then break the loop, as we have no reason to continue it. We already know the result.
					break;
				}
				//Reduce i by 1, counting down. An inverse loopcounter by design choice, since I start by trying to calculate the highest possibilities.
				i--;
			}
			//Check if it is a prime number, based on the result of the previous loop.
			if (isPrime == true) {
				//Save the prime number to the primenumbers array.
				primes[numOfPrimes] = currentNumber;
				//This means I could do more things with the primes afterwards, such as saving them, doing maths with them, etc, because I have them stored in this array, ready to be used later in this program.

				//Then increase the numofprimes variable.
				numOfPrimes++;
				//And then display the number to the user.
				//By doing this after I increase it the user will see the primes counted from 0 to the number chosen, while the array indexing still starts correctly from 0. I could also do this by giving the function numOfPrimes+1, but this way is simpler.
				displayPrimtall(numOfPrimes, currentNumber);
			}
			//Increase the currentNumber before the next time it runs, so it checks the next number instead of going infinite.
			currentNumber++;
		}
	}

	//Since I print the same thing a lot of times, here is a function to do so.
	static void displayPrimtall (int numOfPrimes, int primtall) {
		//And print it.
		System.out.println("PRIMTALL " + numOfPrimes + " : " + primtall);
	}
	/*
	I could make functions here using the prime numbers for something, but I have not done that for this task as it isbeides the point, and in addition I'm terrible at coming up with anything to do with them. Regardless, this can be a useful little script if you need prime numbers for some mathematical issue, and it could easily be picked apart and modified to fit specialized needs.
	*/
}