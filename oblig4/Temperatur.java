import java.util.Scanner;
//In addition to the scanner, we need to import a class that helps us open and read files.
import java.io.File;

class Temperatur {
	public static void main(String[] args) throws Exception {
		//Making a file object so we can use the file.
		File file = new File("temperatur.txt");
		//And make a scanner for the file.
		Scanner in = new Scanner(file);

		//Array to store all the temperatures.
		int[] temps = new int[12];
		//Making the loop counter. Not necessary to stop the file, but used to index the array.
		int i = 0;

		//While the scanner has another line it can read, do things.
		while (in.hasNextLine()) {
			//Get the next line of the file and store it in the array.
			temps[i] = Integer.parseInt(in.nextLine());
			//And loopcounter++.
			i++;
		}

		//Sum of all temperatures.
		//This is a double so I can calculate the avarage with decimals without having to convert the sum.
		double sum = 0;

		//For each element in array.
		for (i = 0; i < temps.length; i++) {
			//Add the next temperature in the array to the sum.
			sum += temps[i]; 
		}
		//And do the division part and store it in a double, in case of decimal numbers.
		double avarage = sum / temps.length;

		System.out.println("Gjennomsnittstemp: " + avarage);
	}
}