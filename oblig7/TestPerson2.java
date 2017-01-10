/*
* This program tests when someone else borrows from the person object, as well as ownership.
*/
import java.util.HashMap;

class TestPerson2 {
	public static void main(String[] args) {
		//Make person
		Person p = new Person("Jason");
		System.out.println("This is " + p.getName());

		//Give him DVDs.
		p.addDVD("Hello Puppy");
		p.addDVD("Inf 101");

		//Number of owned DVDs.
		HashMap<String, Dvd> listO = p.getDVDs();
		System.out.println("Jason owns " + listO.size() + " DVDs.");

		//Try to borrow a DVD he doesn't own.
		if (p.borrowDVDfrom("Hello Ferret", "Jihn")) {
			System.out.println("Someone borrowed a DVD from Jason.");
		} else {
			System.out.println("Someone tried borrowing a DVD Jason doesn't own.");
		}

		//Try to borrow a DVD he owns.
		if (p.borrowDVDfrom("Hello Puppy", "Jihn")) {
			System.out.println("Someone borrowed a DVD from Jason.");
		} else {
			System.out.println("Someone tried borrowing a DVD Jason doesn't own.");
		}

		//Number of DVDs he own.
		listO = p.getDVDs();
		System.out.println("Jason owns " + listO.size() + " DVDs.");

		//Number of DVDs people are borrowing from him.
		HashMap<String, String> listL = p.getLendedDVDs();
		System.out.println("People are borrowing " + listL.size() + " DVDs from Jason.");

		if (p.returnDVDto("Inf 101")) {
			System.out.println("Someone returned a DVD.");
		} else {
			System.out.println("Someone tried to return a DVD they didn't borrow.");
		}

		//Number of DVDs he own.
		listO = p.getDVDs();
		System.out.println("Jason owns " + listO.size() + " DVDs.");

		//Number of DVDs people are borrowing from him.
		listL = p.getLendedDVDs();
		System.out.println("People are borrowing " + listL.size() + " DVDs from Jason.");

		if (p.returnDVDto("Hello Puppy")) {
			System.out.println("Someone returned a DVD.");
		} else {
			System.out.println("Someone tried to return a DVD they didn't borrow.");
		}

		//Number of DVDs he own.
		listO = p.getDVDs();
		System.out.println("Jason owns " + listO.size() + " DVDs.");

		//Number of DVDs people are borrowing from him.
		listL = p.getLendedDVDs();
		System.out.println("People are borrowing " + listL.size() + " DVDs from Jason.");
	}
}