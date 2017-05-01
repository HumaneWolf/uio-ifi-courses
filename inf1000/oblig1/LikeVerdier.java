//Importerer scanner for konsoll input.
import java.util.Scanner;

//Lager class + main nok en gang.
class LikeVerdier {
	public static void main (String [] args) {
		//Definerer tallene C og D som gitt i oppgaven, som heltall.
		//Ikke i bruk fra opppgave C, men inkludert som kommentar av hensyn til oppgaven.
		//int c = 9;
		//int d = 8;

		//Lager et Scanner objekt saa koden kan benytte seg av det.
		Scanner input = new Scanner(System.in);

		//Lag variablene uten og gi de verdier, slik at de kan defineres i try catch og fortsatt vaere tilgjengelig utenfor try catch.
		int c;
		int d;

		//Spoer brukeren etter heltall C.
		System.out.println("Vennligst fyll inn heltall C.");

		//Igjen, try catch for aa ha egen error handling og error melding, i stedet for vanlig runtime error.
		try {
			c = input.nextInt();

			//Lytt etter en spesifikk error, for aa gi error handling.
			//Denne exceptionen er den som oppstaar naar noen ikke fyller inn et gyldig heltall.
		} catch (java.util.InputMismatchException e) {
			//Dersom ikke brukeren ga et gyldig heltall
			//Hopp over en linje for uthevning.
			System.out.println("");
			//Gi en errormelding.
			System.out.println("Vennligst fyll inn et gyldig heltall.");
			//Og igjen, hoppe over en linje.
			System.out.println("");

			//Avslutt programmet.
			//Return avslutter metoden / funksjonen der den er, og kan ogsaa returnere verdier (men det gjoer jeg ikke her).	
			return;
		}

		//Og spoer brukere netter heltall D.
		System.out.println("Vennligst fyll inn heltall D.");

		//Og samme igjen for variabel D.
		try {
			d = input.nextInt();

			//Lytt etter en spesifikk error, for aa gi error handling.
			//Denne exceptionen er den som oppstaar naar noen ikke fyller inn et gyldig heltall.
		} catch (java.util.InputMismatchException e) {
			//Dersom ikke brukeren ga et gyldig heltall
			//Hopp over en linje for uthevning.
			System.out.println("");
			//Gi en errormelding.
			System.out.println("Vennligst fyll inn et gyldig heltall.");
			//Og igjen, hoppe over en linje.
			System.out.println("");

			//Avslutt programmet.
			//Return avslutter metoden / funksjonen der den er, og kan ogsaa returnere verdier (men det gjoer jeg ikke her).	
			return;
		}

		//Sjekke om de er like, saa gi riktig output for situasjonen.
		if (c == d) {
			System.out.println("C og D er like");
		} else {
			System.out.println("C er ikke lik D");
		}
	}
}