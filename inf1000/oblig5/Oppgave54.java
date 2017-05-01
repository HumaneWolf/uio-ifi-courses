class Oppgave54 {
	public static void main(String[] args) {
		Isbod isbod = new Isbod(5);
		isbod.ansett("Geir");
		isbod.ansett("Tore Bjarne");
		isbod.ansett("Pål Kaare Per Petterson");

		System.out.println("");

		isbod.printAlleAnsatte();

		System.out.println("");

		isbod.giSistemannSparken();

		System.out.println("");

		isbod.ansett("Ole Kaare Bjarne Petter Olaf");

		System.out.println("");

		isbod.printAlleAnsatte();
	}
}