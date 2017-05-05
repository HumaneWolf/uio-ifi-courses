abstract class Person {
	protected String name;

	public Person(String navn) {
		name = navn;
	}

	public String hentNavn() {
		return name;
	}

	abstract public void leggTilResept(Resept resept);
}