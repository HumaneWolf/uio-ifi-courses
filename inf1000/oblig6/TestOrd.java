class TestOrd {
	public static void main(String[] args) {
		Ord ord1 = new Ord("bum"); //Make it.
		Ord ord2 = new Ord("bumbum"); //Make it.
		System.out.println("Ord 1: " + ord1.toString());
		System.out.println("Ord 2: " + ord2.toString());
		//Test it
		System.out.println("Ord 1: Antall forekomster: " + ord1.hentAntall());
		System.out.println("Ord 1: Lengde: " + ord1.hentLengde());
		System.out.println("Ord 1: Plass i dokument: " + ord1.plassIDokument());

		System.out.println("Ord 2: Antall forekomster: " + ord2.hentAntall());
		System.out.println("Ord 2: Lengde: " + ord2.hentLengde());
		System.out.println("Ord 2: Plass i dokument: " + ord2.plassIDokument());

		System.out.println("Forekomster for ord 1 okt med 1.");
		ord1.oekAntall(); //Increase occurences.
		//Repeat
		System.out.println("Ord 1: Antall forekomster: " + ord1.hentAntall());
		System.out.println("Ord 1: Lengde: " + ord1.hentLengde());
		System.out.println("Ord 1: Plass i dokument: " + ord1.plassIDokument());
		
		System.out.println("Ord 2: Antall forekomster: " + ord2.hentAntall());
		System.out.println("Ord 2: Lengde: " + ord2.hentLengde());
		System.out.println("Ord 2: Plass i dokument: " + ord2.plassIDokument());
	}
}