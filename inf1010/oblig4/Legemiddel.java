abstract class Legemiddel {
	protected int id;
	protected static int idCounter = 0;

	protected String name;
	protected double price;
	protected double effectiveMaterial;

	public Legemiddel(String navn, double pris, double virkestoff) {
		name = navn;
		price = pris;
		effectiveMaterial = virkestoff;

		id = idCounter;
		idCounter++;
	}

	public int hentId() {
		return id;
	}

    public String hentNavn() {
    	return name;
    }

    public double hentPris() {
    	return price;
    }

    public double hentVirkestoff() {
    	return effectiveMaterial;
    }

    @Override
    public String toString() {
    	return name + " (Virkestoff: " + effectiveMaterial + ")";
    }
}