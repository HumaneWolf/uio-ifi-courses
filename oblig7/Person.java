/*
* Handles a single person and all their DVDs, the DVDs they borrow, others borrow from them, etc.
*/
import java.util.HashMap;

class Person {
	private String name;
	//Stores DVD objects.
	private HashMap<String,Dvd> ownedDVDs = new HashMap<String,Dvd>();

	//Stores references to DVD objects.
	//Key = DVD name, Value = Person borrowing it OR person who lended it away.
	private HashMap<String,String> borrowedDVDs = new HashMap<String,String>(); //Value is person who lended it away, the owner.
	private HashMap<String,String> lendedDVDs = new HashMap<String,String>(); //Value is the person who borrowed it from this person.

	//Constructor. Set name.
	public Person(String n) {
		name = n;
	}

	//Get the persons name.
	public String getName() {
		return name;
	}

	//Get a single DVD the person owns by name.
	public Dvd getDVD(String n) {
		return ownedDVDs.get(n);
	}

	//Get DVDs the person owns.
	public HashMap<String, Dvd> getDVDs() {
		return ownedDVDs;
	}

	//Get references to the DVDs the person is borrowing from others.
	public HashMap<String, String> getBorrowedDVDs() {
		return borrowedDVDs;
	}

	//Get references to the DVDs other people are borrowing from this person.
	public HashMap<String, String> getLendedDVDs() {
		return lendedDVDs;
	}

	//If someone borrows a DVD from the person.
	public boolean borrowDVDfrom(String d, String p) {
		//Check that this person owns the DVD.
		if (ownedDVDs.get(d) != null) {
			//Check that nobody else has borrowed it.
			if (lendedDVDs.get(d) == null) {
				Dvd temp = ownedDVDs.get(d);
				//Lend it to the person if it exists.
				temp.lend(name, p);
				//Save the lender info to the dvd.
				ownedDVDs.put(d, temp);

				//Also save a reference to the lended dvds hashmap.
				//Not the DVD object itself - but enough info to find it.
				lendedDVDs.put(d, p);
				//And return true.
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	//And let people return a dvd this person owns dvd.
	public boolean returnDVDto(String d) {
		//Does this person own the dvd?
		if (ownedDVDs.get(d) != null) {
			//Has anyone borrowed the dvd?
			if (lendedDVDs.get(d) != null) {
				//Remove the data about the person borrowing from the dvd.
				Dvd temp = ownedDVDs.get(d);
				temp.returnDVD();
				//And save.
				ownedDVDs.put(d, temp);
				//Remove the reference to it, making it easy to find that it's borrowed.
				lendedDVDs.remove(d);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	//And let the person buy a new dvd.
	public boolean addDVD(String d) {
		//Does the person already have the DVD?
		if (ownedDVDs.get(d) == null) {
			//Make a DVD object.
			Dvd temp = new Dvd(d, name);
			//Save it.
			ownedDVDs.put(d, temp);
			return true;
		} else {
			return false;
		}
	}

	//If someone lends the person a DVD.
	public boolean lendDVDto(String d, String p) {
		//Check that this person has not already borrowed it.
		if (borrowedDVDs.get(d) == null) {
			//Save a reference so we can find it easily.
			borrowedDVDs.put(d, p);
			return true;
		} else {
			return false;
		}
	}

	//Return a DVD this person borrowed from someone.
	public boolean returnDVDfrom(String d) {
		//Check that this person has borrowed it.
		if (borrowedDVDs.get(d) != null) {
			//Remove reference
			borrowedDVDs.remove(d);
			return true;
		} else {
			return false;
		}
	}
}