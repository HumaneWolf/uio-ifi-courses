class HvitResept extends Resept {
	public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		super(legemiddel, utskrivendeLege, pasientId, reit);
	}

	/**
	*	Returnerer reseptens farge.
	*	@return String "blaa"
	*/
	@Override
	public String farge() {
		return "hvit";
	}

	/**
	*	Returnerer prisen man skal betale.
	*	@return double pris
	*/
	@Override
	public double prisAaBetale() {
		return super.med.hentPris();
	}
}