class Prosessor
{
	private int cores;
	private double speed; //In Hz.

	private final int flopsPerCycle = 8; //Static number given in task.

	public Prosessor(int cores, double speed)
	{
		this.cores = cores;
		this.speed = speed;
	}

	public int getCores()
	{
		return this.cores;
	}

	public double getSpeed()
	{
		return this.speed;
	}

	public double flops()
	{
		return this.cores * this.speed * this.flopsPerCycle;
	}
}