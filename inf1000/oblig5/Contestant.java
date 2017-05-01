//Import a java random number utility.
import java.util.Random;

class Contestant {
	private String name;
	private double health;
	private double baseAttackValue;

	//Constructor. Accepting name, hp and baseattackvalue.
	public Contestant(String n, double h, double bav) {
		name = n;
		health = h;
		baseAttackValue = bav;
	}

	//Remove x from health.
	public void takeDamage(double dmg) {
		//Calculate health after the damage has been taken.
		health = health - dmg;
		//If less than 0, set it back to 0.
		if (health < 0) {
			health = 0;
		}
	}

	//Calculate how much damage the next attack should do.
	public double calculateDamage() {
		//Make a random object.
		Random random = new Random();
		//Get a random modifier for how much dmg they should deal.
		double modifier = random.nextInt(10) + 1; //Random number from 1 to 10.
		modifier = (modifier + 5) / 10; //This will return a number from 0.5 to 1.5.

		//Return the base dmg multiplied with the modifier, allowing the character to deal from 50% to 150% of their baseattack as dmg.
		return baseAttackValue * modifier;
	}

	//Get the name of the contestant.
	public String getName() {
		return name;
	}

	//Get the current health of the contestant.
	public double getHealth() {
		return health;
	}

	//Get the baseattack of the contestant.
	public double getBaseAttackValue() {
		return baseAttackValue;
	}
}