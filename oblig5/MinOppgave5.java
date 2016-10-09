class MinOppgave5 {
	public static void main(String[] args) {
		//Declaring some variables.
		double dmgCalc;
		double hp;

		//Let's make a couple of contestants for the battle.
		Contestant c1 = new Contestant("Dominator", 100, 10.5);
		Contestant c2 = new Contestant("Slightly Less Dominating Dominator", 55, 20);

		//Announcing the combatants.
		System.out.println("Tonights battle:");
		System.out.println(c1.getName() + " with his " + c1.getBaseAttackValue() + " base damage!");
		System.out.println("Versus");
		System.out.println(c2.getName() + " with his " + c2.getBaseAttackValue() + " base damage!");

		System.out.println("");

		//Making a while loop so I can just make the battle continue until one party has lost.
		while (true) {
			//Calculate damage.
			dmgCalc = c1.calculateDamage();
			//Other contestant takes dmg.
			c2.takeDamage(dmgCalc);
			System.out.println(c2.getName() + " takes " + dmgCalc + " damage from " + c1.getName() + "'s attack.");
			//Get health
			hp = c2.getHealth();
			//If the other contestant is now dead, say so.
			if (hp == 0) {
				System.out.println(c2.getName() + " has died. " + c1.getName() + " is the winner!");
				//And end the infinite loop.
				break;
			} else {
				System.out.println(c2.getName() + " now has " + hp + " health.");
			}

			//And again
			dmgCalc = c2.calculateDamage();
			c1.takeDamage(dmgCalc);
			System.out.println(c1.getName() + " takes " + dmgCalc + " damage from " + c2.getName() + "'s attack.");
			hp = c1.getHealth();
			if (hp == 0) {
				System.out.println(c1.getName() + " has died. " + c2.getName() + " is the winner!");
				break;
			} else {
				System.out.println(c1.getName() + " now has " + hp + " health.");
			}
		}
	}
}