class LegemiddelB extends Legemiddel {
	int habitStrengh;

	public LegemiddelB(String navn, double pris, double virkestoff, int styrke) {
		super(navn, pris, virkestoff);
		habitStrengh = styrke;
	}

	public int hentVanedannendeStyrke() {
		return habitStrengh;
	}
}