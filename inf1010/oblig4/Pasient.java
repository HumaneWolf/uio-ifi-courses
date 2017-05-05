class Pasient extends Person {
	protected int id;
	protected static int idCounter = 0;

	protected long fodselsnummer;
	protected String address;
	protected int zipcode;

	protected Stabel<Resept> prescriptions = new Stabel<Resept>();

	public Pasient(String navn, long fodselsnummer, String gateaddresse, int postnummer) {
		super(navn);
		this.fodselsnummer = fodselsnummer;
		address = gateaddresse;
		zipcode = postnummer;

		id = idCounter;
		idCounter++;
	}

	public int hentId() {
		return id;
	}

	public long hentFodselsnummer() {
		return fodselsnummer;
	}

	public String hentGateadresse() {
		return address;
	}

	public int hentPostnummer() {
		return zipcode;
	}

	public void leggTilResept(Resept resept) {
		prescriptions.settInn(resept);
	}

	public Stabel<Resept> hentReseptliste() {
		return prescriptions;
	}

	@Override
	public String toString() {
		return super.name + " (ID: " + id + ", Fodselsnummer: " + fodselsnummer + ")";
	}
}