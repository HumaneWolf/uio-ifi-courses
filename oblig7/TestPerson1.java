/*
* This program tests a person borrowing a DVD from someone.
*/
import java.util.HashMap;

class TestPerson1 {
	public static void main(String[] args) {
		Person p = new Person("Joe");
		System.out.println("This is " + p.getName());

		//Give him a couple of dvds.
		p.addDVD("The escape from somewhere");
		p.addDVD("Thanks Obama");

		//Now, he should borrow one. From Jason.
		if (p.lendDVDto("Thanks Obama 2", "Jason")) {
			System.out.println("He now borrows a DVD.");
		} else {
			System.out.println("He tried borrowing a DVD, but he is borrowing it already.");
		}

		//And the same one again, but he is already borrowing it.
		if (p.lendDVDto("Thanks Obama 2", "Jason")) {
			System.out.println("He now borrows a DVD.");
		} else {
			System.out.println("He tried borrowing a DVD, but he is borrowing it already.");
		}

		//Check the list.
		HashMap<String, String> list = p.getBorrowedDVDs();
		System.out.println("He is currently borrowing " + list.size() + " DVDs.");

		//Now, he should borrow another one. From Jason.
		if (p.lendDVDto("Thanks Obama 3", "Jason")) {
			System.out.println("He now borrows a DVD.");
		} else {
			System.out.println("He tried borrowing a DVD, but he is borrowing it already.");
		}

		//Check the list.
		list = p.getBorrowedDVDs();
		System.out.println("He is currently borrowing " + list.size() + " DVDs.");

		//Return a movie he hasn't borrowed.
		if (p.returnDVDfrom("Thanks Obama 4")) {
			System.out.println("He returned a movie.");
		} else {
			System.out.println("He tried to return a movie he didn't borrow.");
		}

		//Check the list.
		list = p.getBorrowedDVDs();
		System.out.println("He is currently borrowing " + list.size() + " DVDs.");

		//And last but not least return a movie he did borrow.
		if (p.returnDVDfrom("Thanks Obama 3")) {
			System.out.println("He returned a movie.");
		} else {
			System.out.println("He tried to return a movie he didn't borrow.");
		}

		//Check the list.
		list = p.getBorrowedDVDs();
		System.out.println("He is currently borrowing " + list.size() + " DVDs.");
	}
}