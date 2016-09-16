//Importer scanner verktoey for aa hente input fra terminal.
import java.util.Scanner;

//Lager classen og hovedfunksjonen/startfunksjonen/main.
class Beslutninger {
	public static void main (String [] args) {

		//Sette myndighetsalderen.
		final int MYNDIGHETS_ALDER = 18;

		//Setter verdien til alder. Ikke brukt naar jeg henter fra command line, men latt vaere igjen for oppgavens skyld.
		//int alder = 19;

		//Lage et scanner objekt for aa benytte seg av scanner verktoyet.
		Scanner input = new Scanner(System.in);

		//Spoer etter alder
		System.out.println("Vennligst fyll inn din alder i aar.");

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

		//Sjekke om personen er myndig eller ikke, om alderen er lik eller hoeyere myndighetsalderen, som er minimum. Si resultatet.
		if (alder >= MYNDIGHETS_ALDER) {
			System.out.println("Du er myndig");
		} else {
			System.out.println("Du er ikke myndig");
		}
	}
}