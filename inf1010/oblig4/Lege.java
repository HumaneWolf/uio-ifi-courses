class Lege extends Person implements Comparable<Lege> {
	protected Koe<Resept> prescriptions = new Koe<Resept>();

	public Lege(String navn) {
		super(navn);
	}

	public void leggTilResept(Resept resept) {
		prescriptions.settInn(resept);
	}

	public Koe<Resept> hentReseptliste() {
		return prescriptions;
	}

	public int compareTo(Lege annenLege) {
		return super.hentNavn().compareTo(annenLege.hentNavn());
	}
}