class Ord {
	private String word;
	private int occurences = 0;

	//Constructor
	public Ord(String o) {
		word = o;
		occurences++;
	}

	//Return word as string
	public String toString() {
		return word;
	}

	//Get number of occurences of the word.
	public int hentAntall() {
		return occurences;
	}

	//Increase number of occurences
	public void oekAntall() {
		occurences++;
	}

	//Return length
	public int hentLengde() {
		return word.length();
	}

	//Return total number of characters in the document.
	public int plassIDokument() {
		return (word.length() * occurences);
	}
}