abstract class Resept {
	protected int id;
	protected static int idCounter = 0;
	
	protected Legemiddel med;
	protected Lege doc;
	protected int patient;
	protected int reit;

	public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
		med = legemiddel;
		doc = utskrivendeLege;
		patient = pasientId;
		this.reit = reit;

		id = idCounter;
		idCounter++;
	}

	public int hentId() {
		return id;
	}

    public Legemiddel hentLegemiddel() {
    	return med;
    }

    public Lege hentLege() {
    	return doc;
    }

    public int hentPasientId() {
    	return patient;
    }

    public int hentReit() {
    	return reit;
    }

    /**
     * Bruker resepten én gang. Returner false om resepten er
     * oppbrukt, ellers returnerer den true.
     * @return      om resepten kunne brukes
     */
    public boolean bruk() {
    	if (reit > 0) {
    		reit--;
    		return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Returnerer reseptens farge. Enten "blaa" eller "hvit".
     * @return      reseptens farge
     */
    abstract public String farge();

    /**
     * Returnerer prisen pasienten maa betale.
     * @return      prisen pasienten maa betale
     */
    abstract public double prisAaBetale();

    @Override
    public String toString() {
    	return "Pasient: " + patient + " - " + med.hentNavn() + " (" + farge() + ", " + reit + " bruk gjenstår)";
    }
}