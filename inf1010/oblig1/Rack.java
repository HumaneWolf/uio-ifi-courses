class Rack
{
	private Node[] nodes;

	public Rack(int maxSize)
	{
		nodes = new Node[maxSize];
	}

	public boolean addNode(Node node)
	{
		//Have to loop and see if a spot is free since it's an array, size is static.
		for (int i = 0; i < nodes.length; i++)
		{
			//If node slot is free
			if (nodes[i] == null)
			{
				//Assign and end
				nodes[i] = node;
				return true;
			}
		}

		//If no free slot.
		return false;
	}

	public int nodesWithEnoughRam(int ram)
	{
		int counter = 0;
		for (int i = 0; i < nodes.length; i++)
		{
			if (nodes[i] != null)
			{
				//If it has enough ram, count it.
				if (nodes[i].getRam() >= ram)
				{
					counter++;
				}
			}
		}
		return counter;
	}

	public double flops()
	{
		double flops = 0;
		for (int i = 0; i < nodes.length; i++)
		{
			if (nodes[i] != null)
			{
				//Count the flops.
				flops += nodes[i].flops();
			}
		}
		return flops;
	}
}