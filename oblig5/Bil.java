class Bil {
	//Number of kilometers the car has driven in its lifetime.
	private int kilometerstand = 0;
	//Size of fuel tank
	private double tankstorrelse;
	//Fuel consumption per km.
	private double bensinforbruk;
	//And the level of fuel in the tank.
	private double tank;

	//Constructor, setting some of the basic variables.
	public Bil(double tankSize, double fuelConsumpt) {
		//Can't have a -2 liter fuel tank. No no. It is a positive size, set it.
		if (tankSize > 0) {
			//Set the size
			tankstorrelse = tankSize;
			//And fill the tank to the brim.
			tank = tankSize;
		} else {
			//If they set the size of the tank to a negative amount, let's set it to a default value and throw an error instead.
			//Setting it to a default in case they do further operations with the car anyway.
			tankstorrelse = 35; //35 liters.
			tank = 35;
			System.out.println("Advarsel: Du kan ikke ha en tank som rommer 0 liter eller mindre, setter tanken til standardverdien i stedet.");
		}

		//In the same logic, we can't have a car that generates new fuel when driving. Though it would be nice to have.
		//So, if it has a fuel consumption of 0 or higher, let's set the value.
		if (fuelConsumpt >= 0) {
			bensinforbruk = fuelConsumpt;
		} else {
			//Else, if it uses less than 0 fuel (generates fuel), let's set it to a default and tell the user.
			bensinforbruk = 0.06; //realistic amount per km.
			System.out.println("Advarsel: Du kan ikke ha en bil som lager drivstoff naar den kjorer.");
		}
	}

	//Have a drive. Return true if it is able to drive that far, or false if it doesn't have enough fuel.
	public boolean kjorTur(int km) {
		//Does the car have enough fuel to drive that far?
		if ((tank / bensinforbruk) >= km) {
			//If yes, then drive.

			//Calculate new fuel level.
			tank = tank - (km * bensinforbruk);

			//Set the new kilometerstand.
			kilometerstand = kilometerstand + km;

			//And return
			return true;
		} else {
			//If not, return false and error.
			System.out.println("Du kan ikke kjoere saa langt uten aa fylle drivstoff.");
			return false;
		}
	}

	//Fill the fuel tank. Return true if there is enough space in the fuel tank to fill the given amount.
	public boolean fyllTank(double liter) {
		//Is there enough space in the tank?
		if (tankstorrelse >= (tank + liter)) {
			//If the tank is bigger than the current amount of fuel plus the fuel you add, then yes.
			tank = tank + liter;
			return true;
		} else {
			//Else the tank is too small.
			System.out.println("Det er ikke plass til saa mye drivstoff i tanken, saa du kan ikke fylle saa mye.");
			return false;
		}
	}

	//Return the max distance you can drive without refueling, the current range.
	public double hentMaksDistanse() {
		//Fuel the car has, divided by how much it uses per km = kilometers you can drive.
		return tank / bensinforbruk;
	}

	//Return the numbers of kilometers driven in the cars lifetime.
	public int hentKilometerstand() {
		return kilometerstand;
	}
}