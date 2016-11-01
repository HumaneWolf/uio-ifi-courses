import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

class Ordliste {
	private ArrayList<Ord> list = new ArrayList<Ord>();

	//Read the words from a textfile.
	public void lesBok(String filename) throws Exception {
		//Load file and scanner.
		File file = new File(filename);
		Scanner in = new Scanner(file);

		while (in.hasNextLine()) {
			leggTilOrd(in.nextLine());
		}
	}

	//Add a word, internal method.
	private void leggTilOrd(String ord) {
		//Defining a var I use.
		Ord tempOrd;
		//Loop the list of Ord objects
		for (int i = 0; i < list.size(); i++) {
			//Get the ord object.
			tempOrd = list.get(i);
			//If the word input matches the word in the list.
			if (ord.equalsIgnoreCase(tempOrd.toString())) {
				//Increase number of occurences.
				tempOrd.oekAntall();
				//And save.
				list.set(i, tempOrd);
				//And end the function as we found it. No need to run any more.
				return;
			}
		}
		//If we reach this point, the word doesn't exist already.
		tempOrd = new Ord(ord);
		list.add(tempOrd);
	}

	//Find the object for a word.
	public Ord finnOrd(String ord) {
		//Same as leggTilOrd
		//Defining a var I use.
		Ord tempOrd;
		//Loop the list of Ord objects
		for (int i = 0; i < list.size(); i++) {
			//Get the ord object.
			tempOrd = list.get(i);
			//If the word input matches the word in the list.
			if (ord.equalsIgnoreCase(tempOrd.toString())) {
				return tempOrd;
			}
		}
		//Else return null.
		return null;
	}

	//Count words.
	public int antallOrd() {
		return list.size();
	}

	//Number of times a word occur.
	public int antallForekomster(String ord) {
		//Same as finnOrd
		Ord tempOrd;
		for (int i = 0; i < list.size(); i++) {
			tempOrd = list.get(i);
			if (ord.equalsIgnoreCase(tempOrd.toString())) {
				return tempOrd.hentAntall();
			}
		}
		//Else return 0.
		return 0;
	}

	//Return 5 most common.
	public Ord[] vanligste5() {
		//Making vars
		ArrayList<Ord> mostCommon = new ArrayList<Ord>();
		Ord tempOrd;

		//You've seen this loop before.
		for (int i = 0; i < list.size(); i++) {
			tempOrd = list.get(i);
			//Set the first word as the most common word.
			if (mostCommon.isEmpty()) {
				mostCommon.add(tempOrd);
			} else {
				//Loop through the entire scoreboard with each word, placing them in teh right place after comparing.
				for (int j = 0; j < mostCommon.size(); j++) {
					if (mostCommon.get(j).hentAntall() < tempOrd.hentAntall()) {
						mostCommon.add(j, tempOrd);
						//Then end the loop once it's placed (don't need ot check any more.)
						break;
					}
				}
			}
		}

		//Remove all words except the 5 first ones, the 5 words used the most.
		for (int k = 5; k < mostCommon.size(); k++) {
			mostCommon.remove(k);
		}
		
		return mostCommon.toArray(new Ord[mostCommon.size()]);
	}

	//Return longest word.
	public Ord finnLengste() {
		//And almost the same as antallForekomster and finnOrd.
		Ord tempOrd;
		Ord largest = null;
		for (int i = 0; i < list.size(); i++) {
			//The first iteration, just load the first Ord object into the largest var.
			if (i == 0) {
				largest = list.get(0);
			}
			tempOrd = list.get(i);
			if (tempOrd.hentLengde() > largest.hentLengde()) {
				largest = tempOrd;
			}
		}
		//And return stuff.
		return largest;
	}

	//Find shortest word.
	public Ord finnKorteste() {
		//And just repeating the code from finnLengste.
		Ord tempOrd;
		Ord shortest = null;
		for (int i = 0; i < list.size(); i++) {
			//The first iteration, just load the first Ord object into the shortest var.
			if (i == 0) {
				shortest = list.get(0);
			}
			tempOrd = list.get(i);
			if (tempOrd.hentLengde() < shortest.hentLengde()) {
				shortest = tempOrd;
			}
		}
		//And return stuff.
		return shortest;
	}

	//Return the word that has teh most characters in total in teh doc.
	public Ord tarMestPlassIDokument() {
		//And just repeating the code from finnLengste.
		Ord tempOrd;
		Ord mostChars = null;
		for (int i = 0; i < list.size(); i++) {
			//The first iteration, just load the first Ord object into the mostChars var.
			if (i == 0) {
				mostChars = list.get(0);
			}
			tempOrd = list.get(i);
			if (tempOrd.plassIDokument() > mostChars.plassIDokument()) {
				mostChars = tempOrd;
			}
		}
		//And return stuff.
		return mostChars;
	}
}