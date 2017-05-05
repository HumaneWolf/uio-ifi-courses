class Hovedprogram
{
	static private Regneklynge abel;

	public static void main(String[] args)
	{
		abel = new Regneklynge(12);

		//Make the node
		Node node = new Node(64, 8, 2600000000.0, 8, 2600000000.0); // 2.6 GHz = 2600000000 Hz
		//Add it
		for (int i = 0; i < 650; i++)
		{
			abel.settInnNode(node);
		}

		//Make new node
		node = new Node(1024, 8, 2300000000.0, 8, 2300000000.0);
		for (int i = 0; i < 16; i++)
		{
			abel.settInnNode(node);
		}

		//Outputs.
		System.out.println("Samlet FLOPS: " + abel.flops());
		System.out.println("Noder med minst 32 GB ram: " + abel.noderMedNokMinne(32));
		System.out.println("Noder med minst 64 GB ram: " + abel.noderMedNokMinne(64));
		System.out.println("Noder med minst 128 GB ram: " + abel.noderMedNokMinne(128));
		System.out.println("Antall racks: " + abel.antallRacks());
	}
}