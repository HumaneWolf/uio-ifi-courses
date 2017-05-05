class Lastebil extends Fossilbil
{
	protected double load;

	public Lastebil(String regNum, double emission, double load)
	{
		super(regNum, emission);
		this.load = load;
	}

	public double getLoad()
	{
		return load;
	}
}