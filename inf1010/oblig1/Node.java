class Node
{
	private int ram;
	private Prosessor[] cpu = new Prosessor[2];

	//Constructor if one cpu
	public Node(int ram, int cores, int hz)
	{
		//Assign the stuff passed by the user.
		this.ram = ram;
		this.cpu[0] = new Prosessor(cores, hz);
	}

	//Constructor if 2 cpus.
	public Node(int ram, int cores1, double hz1, int cores2, double hz2)
	{
		this.ram = ram;
		this.cpu[0] = new Prosessor(cores1, hz1);
		this.cpu[1] = new Prosessor(cores2, hz2);
	}

	public int getRam()
	{
		return this.ram;
	}

	public Prosessor[] getCpu()
	{
		return this.cpu;
	}

	public double flops()
	{
		double flops = 0;

		//Loop all (both) the processors.
		for (Prosessor p : cpu)
		{
			//In case there is only one processor, since if that's the case then one of the array values will be null.
			if (p != null)
			{
				//Sum
				flops += p.flops();
			}
		}

		return flops;
		//Gives us the same answer as if we had summed the cores and such for the node, but this is more versatile.
		//This works better when a 2 cpu node doesn't have the same clock speed.
	}
}