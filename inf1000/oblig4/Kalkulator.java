class Kalkulator {
	public static void main(String[] args) {
		//Print the math question and the response using the functions.
		System.out.println("10 + 3 = " + addisjon(10, 3));
		System.out.println("10 - 3 = " + subtraksjon(10, 3));
		System.out.println("Heltall: 10 / 3 = " + heltallsdivisjon(10, 3));
		System.out.println("Desimaler: 10 / 3 = " + divisjon(10, 3));
	}

	static int addisjon(int num1, int num2) {
		//Just returning the result. No need to make it harder than it needs to be.
		return num1 + num2;
	}

	static int subtraksjon(int num1, int num2) {
		return num1 - num2;
	}

	static int heltallsdivisjon(int num1, int num2) {
		return num1 / num2;
	}

	//One difference: We use doubles to get decimals.
	static double divisjon(double num1, double num2) {
		return num1 / num2;
	}
}