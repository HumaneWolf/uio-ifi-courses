import java.util.Scanner;
import java.io.File;

class Valg {
	public static void main(String[] args) throws Exception {
		//Load the file.
		File fileObj = new File("stemmer.txt");
		//And make a scanner for it.
		Scanner file = new Scanner(fileObj);

		//Making somewhere to store the numbers of votes.
		//I'm using variables rather than an array, then I can label them by the party name rather than a number that doesn't really tell you anything when you look at the code. An alternative would be a hashmap, or indeed an array. Since everything is hard coded in this program it's no big deal to use variables, however.
		int ap = 0;
		int krf = 0;
		int sp = 0;
		int h = 0;

		//Invalid votes
		int inv = 0;
		//Counting them just in case. 

		//Storing the next line in a variable. Declared here, set and changed in the loop.
		String vote = "";

		//While more lines are available.
		while (file.hasNextLine()) {
			vote = file.nextLine();
			//Check if the input matches each party using if/else statements. If it does, increase the number of votes that party has.
			if (vote.equalsIgnoreCase("ap")) {
				ap++;
			} else if (vote.equalsIgnoreCase("krf")) {
				krf++;
			} else if (vote.equalsIgnoreCase("sp")) {
				sp++;
			} else if (vote.equalsIgnoreCase("h")) {
				h++;
			} else {
				//If it matches neither it is invalid.
				inv++;
			} 
		}

		//Find the winner. Check if each party has more votes than all the others.
		if (ap > krf && ap > sp && ap > h) { //AP
			//And announce the winner.
			System.out.println("Vinneren er AP.");
		} else if (krf > ap && krf > sp && krf > h) { //KrF
			System.out.println("Vinneren er KrF.");
		} else if (sp > ap && sp > krf && sp > h) { //SP
			System.out.println("Vinneren er SP.");
		} else if (h > ap && h > sp && h > krf) { //H
			System.out.println("Vinneren er H.");
		} else {
			System.out.println("Det er uavgjort!"); //Dersom to partier har like mange stemmer, altså ingen har mer enn alle andre, vil denne printes.
		}
		//Dividing line and the full results.
		System.out.println("=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.=");
		System.out.println("RESULTATER:");
		System.out.println("AP: " + ap);
		System.out.println("KrF: " + krf);
		System.out.println("SP: " + sp);
		System.out.println("H: " + h);

		//IF there were any invalid votes, say so.
		if (inv > 0) {
			System.out.println("Det var " + inv + " ugyldige stemmer.");
		}
	}
}