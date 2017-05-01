//Importer scanner verktoey for aa hente input fra terminal.
import java.util.Scanner;

//Lager class + main
class Billettpris {
	public static void main (String [] args) {

		//Sette hunnoeralderen.
		final int HONNOER_ALDER = 67;
		//Sette barnealderen
		final int BARN_ALDER = 12;
		//Sette prisen
		final int FULLPRIS = 50;
		//Og legge inn funksjon for aa sette den reduserte prisen for barn og honnoer.
		final int RABATT = FULLPRIS / 2;


		//Lage et scanner objekt for aa benytte seg av scanner verktoeyet.
		Scanner input = new Scanner(System.in);

		//Spoer etter alder
		System.out.println("Vennligst fyll inn alder i aar.");

		//Definere variabel utenfor try slik at den ogsaa kan brukes utenfor try.
		int alder;

		//Legge til at den skal proeve det, saa jeg kan gi error melding om brukeren ikke gir et gyldig heltall.
		//Utenfor Try Catch vil Java gi runtime error, men i try catch kan jeg gi egen error.
		try {
			//Godta alder input og lagre den til en variabel.
			alder = input.nextInt();

			//Lytt etter en spesifikk error, for aa gi error handling.
			//Denne exceptionen er den som oppstaar naar noen ikke fyller inn et gyldig heltall.
		} catch (java.util.InputMismatchException e) {
			//Dersom ikke brukeren ga et gyldig heltall
			//Hopp over en linje for uthevning.
			System.out.println("");
			//Gi en errormelding.
			System.out.println("Vennligst fyll inn en gyldig alder i aar med heltall.");
			//Og igjen, hoppe over en linje.
			System.out.println("");

			//Avslutt programmet.
			//Return avslutter metoden / funksjonen der den er, og kan ogsaa returnere verdier (men det gjoer jeg ikke her).	
			return;
		}

		//Sjekker om alder er OVER honnoeralderen og UNDER barnealderen
		if (alder > HONNOER_ALDER || alder < BARN_ALDER) {
			//Gi pris ved hjelp av konstanten RABATT - den ferdige rabatterte prisen.
			System.out.println("Du kan reise for " + RABATT + " kroner.");
		} else {
			//Eller gi fullpris.
			System.out.println("Du kan reise for " + FULLPRIS + " kroner.");
		}
	}
}