class Fastlege extends Lege implements Kommuneavtale {
	protected int contractNumber;

	public Fastlege(String navn, int avtalenummer) {
		super(navn);
		contractNumber = avtalenummer;
	}

	public int hentAvtalenummer() {
		return contractNumber;
	}
}