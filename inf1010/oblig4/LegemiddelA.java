class LegemiddelA extends Legemiddel {
	int narcStrengh;

	public LegemiddelA(String navn, double pris, double virkestoff, int styrke) {
		super(navn, pris, virkestoff);
		narcStrengh = styrke;
	}

	public int hentNarkotiskStyrke() {
		return narcStrengh;
	}
}