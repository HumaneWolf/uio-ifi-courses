/* EGEN OPPGAVE:
Omregning mellom valutaer.
Lage et program som kan regne om mellom norske kroner, danske kroner, svenske kroner, euro, amerikanske dollar og pund.
Kan veldig enkelt lage en lokke av programmet saa man kan kjore det igjen og igjen, men det var ikke poenget med denne oppgaven.
*/
//Importere scanner.
import java.util.Scanner;
//Import a tool to format decimal numbers, used to limit number of decimals.
import java.text.DecimalFormat;

class MinOppgave2 {

	//Defining the exchange rate variables here, outside of all functions. This makes them accessible in the entire class, rather than just in one function/method where I define them. I also use the final keyword, so that nothing can change them while the program is running. They are set from the start.
	//All variables display how much you get in the currency if you have 1 USD.
	final static double nok = 8.24; //Norske kroner
	final static double sek = 8.55; //Svenske kroner
	final static double dkk = 6.66; //Danske kroner
	final static double eur = 0.89; //Euro
	final static double gbp = 0.74; //Britiske pund
	final static double usd = 1; //Amerikanske dollar.

	public static void main (String [] args) {
		//Make the scanner object.
		Scanner input = new Scanner(System.in);

		//Ask the user for the currency they have.
		System.out.println("Vennligst fyll inn hvilken valuta du vil regne om fra.");
		System.out.println("Possible options: NOK, DKK, SEK, EUR, GBP and USD.");

		//And accept a string input.
		String currency = input.nextLine();

		//Request the amount from the user.
		System.out.println("Vennligst fyll inn hvor mye du har av den valgte valutaen.");
		//Use a try/catch for error handling in case they enter something invalid, i.e. not a double.
		//And make the variable outside of it.
		double value;
		try {
			//and accept their input as a double.
			value = Double.parseDouble(input.nextLine());
		} catch (java.lang.NumberFormatException e) { //Listen to the error if they enter a string rather than a double.
			//And give them a message.
			System.out.println("ERROR: Pass paa at du fyller inn et gyldig belop. Bruk punktum (.) i stedet for komma.");
			return; //And last but not least, end the program if the error is triggered.
		}

		//Check if the amount given is less than 0, so we can handle that as an error.
		if (value < 0) {
			//Give an error if it's less than 0, or equal to 0.
			System.out.println("ERROR: Vennligst fyll inn et belop paa mer enn 0.");
			return; //And end the program, because we're not allowing this.
		}
		//If it's above 0, code continues:

		//Use our function to get the amount in USD.
		double valInUSD = getUSD(value, currency);
		if (usd >= 0) { //Check that it is above 0..
			//Call our function to make it print the value in various currencies.
			printValue(valInUSD);
		} else {
			System.out.println("ERROR: Pass paa at du fyller inn en gyldig valuta og et gyldig belop.");
		}
	}

	static void printValue(double inp) {
		//Make a decimal format object we can use to round the doubles.
		DecimalFormat df = new DecimalFormat("#.##");
		//Format: "#.##" - This means it can have numbers in front of hte dot, but no more than 2 decimals behind it. Makes the result prettier.

		//Print the values in the various currencies to the console:
		//Also calculate them, using math magic.
		//The df.format uses the DecimalFormat created above to round the numbers and format them to have 2 decimals.
		System.out.println("Verdien i forskjellige valutaer:");
		System.out.println("NOK: " + df.format(inp * nok));
		System.out.println("DKK: " + df.format(inp * dkk));
		System.out.println("SEK: " + df.format(inp * sek));
		System.out.println("EUR: " + df.format(inp * eur));
		System.out.println("GBP: " + df.format(inp * gbp));
		System.out.println("USD: " + df.format(inp * usd));
	}

	//Takes the number of whatever currency you have, and which currency, then returns the amount you have in dollars so it can be used for further calculations.
	static double getUSD(double value, String currency) {
		//Defining a variable that will hold the applicable currency's value compared to USD.
		double cur;

		//And checking if the given currency is valid (can this program deal with it).
		if (currency.equalsIgnoreCase("nok")) {
			cur = nok;
		} else if (currency.equalsIgnoreCase("sek")) {
			cur = sek;
		} else if (currency.equalsIgnoreCase("dkk")) {
			cur = dkk;
		} else if (currency.equalsIgnoreCase("eur")) {
			cur = eur;
		} else if (currency.equalsIgnoreCase("gbp")) {
			cur = gbp;
		} else if (currency.equalsIgnoreCase("usd")) {
			cur = usd;
		} else {
			//Return -1 if the currency given is unknown. Allows easier error handling in main.
			return -1;
		}

		//If currency is known, return the amount in USD.
		return value / cur;
	}
}