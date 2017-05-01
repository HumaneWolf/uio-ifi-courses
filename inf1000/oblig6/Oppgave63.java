class Oppgave63 {
	public static void main(String[] args) throws Exception {
		Ordliste ol = new Ordliste();

		ol.lesBok("scarlet.txt");

		System.out.println("Antall ord: " + ol.antallOrd() + "\n");

		System.out.println("Antall ganger ordet \"Watson\" er brukt: " + ol.antallForekomster("Watson") + "\n");

		System.out.println("Antall ganger ordet \"elementary\" er brukt: " + ol.antallForekomster("elementary") + "\n");

		System.out.println("5 vanligste ord:");
		Ord[] tempOrd = ol.vanligste5();
		for (int i = 0; i < tempOrd.length; i++) {
			System.out.println(tempOrd[i].toString() + " (brukt " + tempOrd[i].hentAntall() + " ganger)");
		}
		System.out.println("");

		System.out.println("Lengste ord: " + ol.finnLengste() + "\n");

		System.out.println("Korteste ord: " + ol.finnKorteste() + "\n");

		System.out.println("Tar mest plass i dokumentet: " + ol.tarMestPlassIDokument() + "\n");
	}
}