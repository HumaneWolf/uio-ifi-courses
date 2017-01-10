/*
* Handles all data and actions regarding a single DVD.
*/
class Dvd {
	private String title;
	private String owner;
	private String lendedby = "";
	private String borrowedto = "";

	//Constructor.
	public Dvd(String t, String o) {
		title = t;
		owner = o;
	}

	//Get DVD title
	public String getTitle() {
		return title;
	}

	//Get DVD owner
	public String getOwner() {
		return owner;
	}

	//Get the person borrowing it.
	public String getBorrower() {
		//Return null if the name of the person borrowing it is an empty string = nobody borrowing it.
		if (borrowedto.equalsIgnoreCase("")) {
			return null;
		} else {
			return borrowedto;
		}
	}

	//Get the person lending it (always the owner with how the task is set up, but for some reason specified as it's own thing.)
	public String getLender() {
		//Return null if the name of the person lending it away is an empty string = nobody borrowing it.
		if (lendedby.equalsIgnoreCase("")) {
			return null;
		} else {
			return lendedby;
		}	
	}

	//Let someone borrow the dvd, lend it to them.
	//Person lending, person borrowing. Referenced by name.
	public void lend(String l, String b) {
		lendedby = l;
		borrowedto = b;
	}

	//And let them return it.
	public void returnDVD() {
		//Resets the lending and borrowing info.
		lendedby = "";
		borrowedto = "";
	}
}