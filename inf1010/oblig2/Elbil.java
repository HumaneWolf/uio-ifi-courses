class Elbil extends Bil
{
	protected double battery;

	public Elbil(String regNum, double battery)
	{
		super(regNum);
		this.battery = battery;
	}

	public double getBattery()
	{
		return battery;
	}
}