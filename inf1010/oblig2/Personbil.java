class Personbil extends Fossilbil
{
	protected int seats;

	public Personbil(String regNum, double emission, int seats)
	{
		super(regNum, emission);
		this.seats = seats;
	}

	public int getSeats()
	{
		return seats;
	}
}