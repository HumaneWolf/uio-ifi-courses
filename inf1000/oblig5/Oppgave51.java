class Oppgave51 {
	public static void main(String[] args) {
		System.out.println("TESTER KLASSEN BIL");
		System.out.println("------------------");

		System.out.println("BIL 1");
		System.out.println("Prover 100 liter tank, 5 liter forbruk per km.");
		testBil(100, 5); //100 liter tank, 5 liter forbruk per km. Ikke veldig effektivt.

		System.out.println("BIL 2");
		System.out.println("Prover 70 liter tank, 0.05 liter forbruk per km.");
		testBil(70, 0.05);

		System.out.println("BIL 3");
		System.out.println("Prover 0 liter tank, 0 liter forbruk per km.");
		testBil(0, 0);

		System.out.println("BIL 4");
		System.out.println("Prover -7 liter tank, -0.05 liter forbruk per km.");
		testBil(-7, -0.05);
	}

	//Since writing every test code is bothersome, I make a method to test it instead, just filling in some variables.
	static void testBil(double tank, double consumption) {
		Bil bilen = new Bil(tank, consumption);

		System.out.println("Sjekker hvor langt bilen kan kjore uten aa fylle tanken");
		System.out.println(bilen.hentMaksDistanse() + " km");

		System.out.println("Prover aa fylle tanken med 20 liter");
		if (bilen.fyllTank(20)) {
			System.out.println("Suksess");
		} else {
			System.out.println("Mislyktes");
		}

		System.out.println("Prover aa kjore 99999 km");
		if (bilen.kjorTur(99999)) {
			System.out.println("Suksess");
		} else {
			System.out.println("Mislyktes");
		}

		System.out.println("Prover aa kjore 10 km");
		if (bilen.kjorTur(10)) {
			System.out.println("Suksess");
		} else {
			System.out.println("Mislyktes");
		}

		System.out.println("Sjekker hvor langt bilen kan kjore uten aa fylle tanken");
		System.out.println(bilen.hentMaksDistanse() + " km");

		System.out.println("Prover aa kjore 10 km");
		if (bilen.kjorTur(10)) {
			System.out.println("Suksess");
		} else {
			System.out.println("Mislyktes");
		}

		System.out.println("Sjekker kilometerstand");
		System.out.println(bilen.hentKilometerstand() + " km");

		System.out.println("");
	}
}