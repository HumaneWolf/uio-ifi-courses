/*
* Test program.
* Testing the DVD class by making a DVD and using various methods.
*/
class TestDvd {
	public static void main(String[] args) {
		Dvd dvd = new Dvd("Hello World", "Foo Bar");

		System.out.println("Current DVD: " + dvd.getTitle() + " (owner: " + dvd.getOwner() + ").");

		System.out.println("Borrowed by: " + dvd.getBorrower());

		System.out.println("Jason borrows it.");
		dvd.lend("Foo Bar", "Jason");

		System.out.println("Borrowed by: " + dvd.getBorrower());

		System.out.println("Jason returns it.");
		dvd.returnDVD();

		System.out.println("Borrowed by: " + dvd.getBorrower());
	}
}