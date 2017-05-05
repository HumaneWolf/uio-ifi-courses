abstract class Fossilbil extends Bil
{
	protected double emission;

	public Fossilbil(String regNum, double emission)
	{
		super(regNum);
		this.emission = emission;
	}

	public double getEmission()
	{
		return emission;
	}
}