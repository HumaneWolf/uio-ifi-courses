import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Hovedprogram
{
	private static ArrayList<Bil> cars = new ArrayList<Bil>();

	public static void main(String[] args)
	{
		//Variables.
		char filter = 'A';
		Scanner file; 

		//Check if a file is specified.
		if (args.length >= 1)
		{
			//Load file and handle exception.
			try
			{
				file = new Scanner(new File(args[0]));
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Filen eksisterer ikke.");
				return; //Kill the program.
			}
		}
		else
		{
			//If no file is specified, shout at the user.
			System.out.println("Ingen fil spesifisert.");
			System.out.println("Bruk: java hovedprogram <fil> [filter]");
			return; //End program.
		}

		//Store filter as a char, making it easier to work with later.
		//If a filter is specified.
		if (args.length >= 2)
		{
			if (args[1].equalsIgnoreCase("EL"))
			{
				filter = 'E';
			}
			else if (args[1].equalsIgnoreCase("FOSSIL"))
			{
				filter = 'F';
			}
		}

		//Temp variables for the loop.
		String line; 
		String[] lineSplit;
		//Then load the file.
		//If the task didn't say otherwise, I would only create objects for the cars I'm supposed to show.
		while (file.hasNextLine())
		{
			line = file.nextLine();
			lineSplit = line.split(" ");

			if (lineSplit[0].equalsIgnoreCase("EL"))
			{
				cars.add(new Elbil(lineSplit[1], Double.parseDouble(lineSplit[2])));
			}
			else if (lineSplit[0].equalsIgnoreCase("PERSONBIL"))
			{
				cars.add(new Personbil(lineSplit[1], Double.parseDouble(lineSplit[2]), Integer.parseInt(lineSplit[3])));
			}
			else if (lineSplit[0].equalsIgnoreCase("LASTEBIL"))
			{
				cars.add(new Lastebil(lineSplit[1], Double.parseDouble(lineSplit[2]), Double.parseDouble(lineSplit[3])));
			}
		}

		Elbil tempEl;
		Personbil tempPe;
		Lastebil tempLa;
		//Loop and print cars based on the filter.
		for (Bil c : cars)
		{
			//If we want electric cars or all cars and it is an electric car.
			if ((filter == 'E' || filter == 'A') && (c instanceof Elbil))
			{
				//No need for error handling, if it isn't an Elbil it will never reach this point.
				tempEl = (Elbil) c;
				System.out.println("KJORETOY TYPE: Elbil");
				System.out.println("Reg.nr: " + tempEl.getRegNum());
				System.out.println("Batteri: " + tempEl.getBattery());
				System.out.println("");
			}
			else if ((filter == 'F' || filter == 'A') && (c instanceof Fossilbil)) //If we want fossil (or all) cars and this is one.
			{
				//Check what kind of fossil car (personbil or lastebil).
				if (c instanceof Personbil)
				{
					tempPe = (Personbil) c;
					System.out.println("KJORETOY TYPE: Personbil");
					System.out.println("Reg.nr: " + tempPe.getRegNum());
					System.out.println("Utslipp: " + tempPe.getEmission());
					System.out.println("Seter: " + tempPe.getSeats());
					System.out.println("");
				}
				else
				{
					tempLa = (Lastebil) c;
					System.out.println("KJORETOY TYPE: Lastebil");
					System.out.println("Reg.nr: " + tempLa.getRegNum());
					System.out.println("Utslipp: " + tempLa.getEmission());
					System.out.println("Maks last: " + tempLa.getLoad());
					System.out.println("");
				}
			}
		}
	}
}