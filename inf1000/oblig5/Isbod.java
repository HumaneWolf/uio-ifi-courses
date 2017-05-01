class Isbod {
	//defien variables
	private String[] employees = new String[10];
	private int numOfEmployees = 0;
	private int maxNumOfEmployees;

	public Isbod(int maxEmp) {
		maxNumOfEmployees = maxEmp;
	}

	//Hire someone new.
	public void ansett(String navn) {
		if (numOfEmployees < maxNumOfEmployees) {
			//Register name and employee count
			employees[numOfEmployees] = navn;
			numOfEmployees++;
			System.out.println(navn + " ble ansatt.");
		} else {
			System.out.println("Isboden er full.");
		}
	}

	//Fire the latest hire.
	public void giSistemannSparken() {
		//Print who got fired to the terminal.
		System.out.println("Gir " + employees[numOfEmployees-1] + " sparken.");
		//And change the array and vars.
		employees[numOfEmployees-1] = null; //Set it to none.
		numOfEmployees--;
	}

	//List all employees.
	public void printAlleAnsatte() {
		System.out.println("Ansatte:");
		//Loop through all the employees, starting with 0, based on the number of employees. This way it won't print the empty strings.
		for (int i = 0; i < numOfEmployees; i++) {
			System.out.println("#" + (i+1) + ": " + employees[i]);
		}
	}
}