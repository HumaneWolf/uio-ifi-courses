class BlaaResept extends Resept {
	public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		super(legemiddel, utskrivendeLege, pasientId, reit);
	}

	/**
	*	Returnerer reseptens farge.
	*	@return String "blaa"
	*/
	@Override
	public String farge() {
		return "blaa";
	}

	/**
	*	Returnerer prisen man skal betale.
	*	@return double pris
	*/
	@Override
	public double prisAaBetale() {
		return super.med.hentPris() / 0.25;
	}
}