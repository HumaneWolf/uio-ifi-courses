import java.util.ArrayList;

class Regneklynge {
	int rackSizes;
	ArrayList<Rack> racks = new ArrayList<Rack>();

	public Regneklynge(int rackSize)
	{
		this.rackSizes = rackSize;
	}

	public void settInnNode(Node node)
	{
		//Loop existing racks.
		for (Rack n : this.racks)
		{
			//Attempt to insert: If it succeeds
			if (n.addNode(node) == true)
			{
				return;
			}
			//If not, continue looping.
		}
		//If it reaches this point, it hasn't been able to insert it in an existing rack.
		Rack temp = new Rack(this.rackSizes);
		temp.addNode(node);
		this.racks.add(temp);
	}

	public int noderMedNokMinne(int paakrevdMinne)
	{
		//Loop and count.
		int nodes = 0;
		for (Rack n : this.racks)
		{
			nodes += n.nodesWithEnoughRam(paakrevdMinne);
		}
		return nodes;
	}

	public int antallRacks()
	{
		return this.racks.size();
	}

	public double flops()
	{
		//Loop and do the math. again.
		double flops = 0;
		for (Rack n : this.racks)
		{
			flops += n.flops();
		}
		return flops;
	}
}