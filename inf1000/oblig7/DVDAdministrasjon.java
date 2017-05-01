/*
* This class is the main wrapper for the entire program, handling all user input and interaction as well as managing all people registered.

While it may seem a bit messy at first - The program has a consistent structure.
- Main is responsible for the menu as well as user input and displaying any errors.
- The logic is separated into different methods.
- Consistent naming.
*/
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

class DVDAdministrasjon {
	private static HashMap<String, Person> people = new HashMap<String, Person>();
	private static Scanner in = new Scanner(System.in);

	//Display menu.
	public static void main(String[] args) throws Exception {
		String input;

		//Get the file.
		readFile();

		//Display it until they choose to quit.
		while(true) {
			System.out.println("=.=.=.= HOVEDMENY =.=.=.=");
			System.out.println("Angi nummeret for ditt valg.");
			System.out.println("1. Ny Person");
			System.out.println("2. Kjop DVD");
			System.out.println("3. Laan DVD");
			System.out.println("4. Vis Person");
			System.out.println("5. Vis Oversikt");
			System.out.println("6. Retur");
			System.out.println("7. Avslutt");
			System.out.println("=.=.=.=.=.=.=.=");

			input = in.nextLine();
			/*
			Each function will return an integer to inform about the result.
			0 is ALWAYS success.
			1 is ALWAYS the person doesn't exist.
			2 and higher are custom per function (but never success). See comments by the return statement.

			Gathering input is done in this if/else statement - the logic is done in separate methods.
			*/
			if (input.equalsIgnoreCase("1")) { // ADD PERSON
				System.out.println("Hva heter personen?");
				String name = in.nextLine();

				if (addPerson(name) == 0) {
					System.out.println(name + " er lagt til i systemet.");
				} else {
					System.out.println("Denne personen eksisterer allerede.");
				}


			} else if (input.equalsIgnoreCase("2")) { // BUY DVD
				System.out.println("Hvilken person kjoper DVDen?");
				String name = in.nextLine();
				System.out.println("Hvilken DVD kjoper personen?");
				String title = in.nextLine();

				int result = buyDVD(name, title);
				if (result == 0) {
					System.out.println("DVDen er lagt til.");
				} else if (result == 1) {
					System.out.println("Personen eksisterer ikke.");
				} else {
					System.out.println("Personen eier allerede denne DVDen.");
				}


			} else if (input.equalsIgnoreCase("3")) { // BORROW DVD
				System.out.println("Hvilken person vil laane?");
				String borrowerName = in.nextLine();
				System.out.println("Hvilken person skal det laanes fra?");
				String ownerName = in.nextLine();
				System.out.println("Hva heter DVDen?");
				String title = in.nextLine();

				int result = borrowDVD(borrowerName, ownerName, title);
				if (result == 0) {
					System.out.println(borrowerName + " har laant " + title + " av " + ownerName + ".");
				} else if (result == 1) {
					System.out.println("Personen som skal laane eksisterer ikke.");
				} else if (result == 2) {
					System.out.println("Eieren av DVDen eksisterer ikke.");
				} else if (result == 3) {
					System.out.println("Du kan ikke laane av deg selv.");
				} else {
					System.out.println("Denne DVDen er ikke tilgjengelig for utlaan.");
				}


			} else if (input.equalsIgnoreCase("4")) { //GET PERSON
				System.out.println("Hvilken person vil du hente profilen til?");
				String name = in.nextLine();

				if (getPerson(name) != 0) {
					System.out.println("Personen finnes ikke.");
				}


			} else if (input.equalsIgnoreCase("5")) {
				getSummary();
				//No error handling necessary.


			} else if (input.equalsIgnoreCase("6")) {
				System.out.println("Hvilken person skal levere en DVD?");
				String name = in.nextLine();
				System.out.println("Hvilken DVD skal personen levere?");
				String title = in.nextLine();

				int result = returnDVD(name, title);
				if (result == 0) {
					System.out.println("DVDen er levert.");
				} else if (result == 1) {
					System.out.println("Denne personen eksisterer ikke.");
				} else {
					System.out.println("Denne personen har ikke laant denne DVDen.");
				}


			} else if (input.equalsIgnoreCase("7")) {
				System.out.println("Hade.");
				//quit. Break the loop.
				break;
			}

			//Neatness when viewing a lot of info:
			System.out.println("");
			System.out.println("Press enter for aa gaa tilbake til menyen.");
			in.nextLine();
		}
	}

	//Handles everything related to adding a person.
	private static int addPerson(String name) {
		//Do they already exist in the system?
		if (people.get(name) == null) {
			Person temp = new Person(name);
			people.put(name, temp);
			return 0;
		} else {
			return 2;
			//Person already exist.
		}
	}

	//If a person buys a DVD.
	private static int buyDVD(String name, String title) {
		//Does the person exist?
		if (people.get(name) != null) {
			Person temp = people.get(name);
			//Try to add the DVD. Will fail if they already have it.
			if (temp.addDVD(title)) {
				//And save.
				people.put(name, temp);
				return 0;
			} else {
				return 2;
				//The person already own this DVD.
			}
		} else {
			return 1;
			//Person does not exist.
		}
	}

	private static int borrowDVD(String borrowerName, String ownerName, String title) {
		Person borrower;
		Person owner;

		if (people.get(borrowerName) != null) {
			if (people.get(ownerName) != null) {
				//If the person borrowing and the owner are not the same person.
				if (!borrowerName.equalsIgnoreCase(ownerName)) {
					//Load the people involved.
					borrower = people.get(borrowerName);
					owner = people.get(ownerName);
					//Try to borrow it: will return false if the person does not own the DVD or it's not available.
					if (owner.borrowDVDfrom(title, borrowerName)) {
						//And save it for the person borrowing the DVD.
						borrower.lendDVDto(title, ownerName);
						//And save.
						people.put(ownerName, owner);
						people.put(borrowerName, borrower);

						return 0;
					} else {
						return 4;
						//DVD not available for lending.
					}
				} else {
					return 3;
					//You can't borrow from yourself.
				}
			} else {
				return 2;
				//The owner does not exist.
			}
		} else {
			return 1;
			//The person does not exist.
		}
	}

	private static int getPerson(String name) {
		//Does the person exist?
		if (people.get(name) != null) {
			//Show stuff.
			showPerson(name);
			return 0;
		} else if (name.equalsIgnoreCase("*")) {
			//Loop through all people.
			for (Person p : people.values()) {
				showPerson(p.getName());
			}
			return 0;
		} else {
			return 1;
			//Person does not exist.
		}
	}

	//Giving a summary of everyone, as a list.
	private static int getSummary() {
		//Header
		System.out.println("Oversikt:");
		System.out.println("Format: Navn (Eide DVDer / utlaante DVDer / laante DVDer)");
		//Looping through everyone.
		for (Person p : people.values()) {
			//Print name
			System.out.print(p.getName() + " (");
			//Print owned DVDs
			System.out.print(p.getDVDs().size() + " / ");
			//Print DVDs others borrow.
			System.out.print(p.getLendedDVDs().size() + " / ");
			//And DVDs they borrow from others, as well as a new line.
			System.out.println(p.getBorrowedDVDs().size() + ")");
		}

		return 0;
		//Return success. Not strictly needed as it can't go wrong, but added for neatness.
	}

	//Return a DVD to it's owner.
	private static int returnDVD(String name, String title) {
		Person p; //Person borrowing
		Person o; //owner
		Dvd d; //DVD
		HashMap<String, String> temp;//Temporary storage of a hashmap.

		//If the person exists.
		if (people.get(name) != null) {
			p = people.get(name);
			//Get the list of DVDs the person has borrowed.
			temp = p.getBorrowedDVDs();
			//Use it to get the name of and then load the owner of the DVD.
			//The value in the temp hashmap is the name of the owner.
			o = people.get(temp.get(title));

			//Return the DVD from the borrower.
			if (p.returnDVDfrom(title)) {
				//Return the DVD to the owner.
				o.returnDVDto(title);
				return 0;
			} else {
				return 2;
				//The person didn't borrow that DVD.
			}
		} else {
			return 1;
			//Person does not exist.
		}
	}



	//Method handling reading from the file.
	private static void readFile() throws Exception {
		Scanner file = new Scanner(new File("dvdarkiv.txt"));

		//Setting necessary variables.
		String currentLine;
		String currentName = "";
		Boolean readingNames = true; //Turns false after all the names are added.

		//Loop through.
		while (file.hasNextLine()) {
			if (readingNames == true) {
				currentLine = file.nextLine();
				if (currentLine.equalsIgnoreCase("-")) {
					//Done with names, first - of the file.
					readingNames = false;

					//If there are any DVDs/names.
					if (file.hasNextLine()) {
						//Find out who's DVDs it will read when it continues.
						currentName = file.nextLine();
					}
					//If it doesn't have any more lines the loop will stop anyway. The above if statement prevents runtime error.
				} else {
					addPerson(currentLine);
					//Will only add it if the person don't already exist, this is checked in addPerson.
				}
			} else {
				currentLine = file.nextLine();
				//If it's done with that person (the ending -).
				if (currentLine.equalsIgnoreCase("-")) {
					//If there are more people.
					if (file.hasNextLine()) {
						//Save next name.
						currentName = file.nextLine();
					}
					//Else it's done.
				} else {
					//If it isn't a line - We got a movie to add.

					//Is someone borrowing it?
					if (currentLine.charAt(0) == '*') {
						//Remove the *. This gets the string starting at slot 1, to the end.
						currentLine = currentLine.substring(1);
						//Add it
						buyDVD(currentName, currentLine);
						//Then add that a person is borrowing it.
						borrowDVD(file.nextLine(), currentName, currentLine);
					} else {
						//Nobody borrowing it. Just add it.
						buyDVD(currentName, currentLine);
					}
				}
			}
		}
	}



	//Method to show a persons full profile, because I do that on more than one occasion.
	private static void showPerson(String name) {
		Person p;
		HashMap<String, Dvd> ownedDVDs;
		HashMap<String, String> borrowedDVDs;

		p = people.get(name);
		//Get their DVDs
		ownedDVDs = p.getDVDs();
		borrowedDVDs = p.getBorrowedDVDs();

		//skip a line and print info.
		System.out.println("");
		System.out.println("Navn: " + p.getName());

		System.out.println("Eide DVDer:");
		//Loop through them. Enhanced for loop.
		for (Dvd d : ownedDVDs.values()) {
			//If nobody is borrowing them.
			if (d.getBorrower() == null) {
				System.out.println(d.getTitle());
			} else {
				//Or if someone is borrowing it.
				System.out.println(d.getTitle() + " (Utlånt til " + d.getBorrower() + " av " + d.getLender() + ")");
			}
		}

		System.out.println("");

		System.out.println("Laante DVDer:");
		//Loop through them as well. Again enhanced for loop.
		for (String d : borrowedDVDs.keySet()) {
			//Show the DVD.
			System.out.println(d + " (laant av " + borrowedDVDs.get(d) + ")");
		}
	}
}