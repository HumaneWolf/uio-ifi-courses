class Alternativ2 {
	public static void main (String [] args) {
		/*
		Making a test array to run the skrivKarakterProtokoll method.
		Some random values, but some special ones as well:
		40 - Borderline value, max limit. Worth checking.
		39 - Next to borderline value.
		0 - Borderline value, minimum limit.
		1 - Next to borderline value.
		123 - Outside the max/minimum values, worth checking.
		*/
		int[] array = {40, 40, 39, 12, 123, 24, 1, 0, 20, 35};
		skrivKarakterprotokoll(array);

	}

	static void skrivKarakterprotokoll(int[] poeng) {
		//Make a loop run counter thingy.
		int c = 0;
		
		//Make the loops itself.
		//array.length gets the number of elements you can have in an array, and in this case we are assuming it's filled. Array length can vary, adn thus we use .length instead of a magic number.
		while (c < poeng.length) {
			//Checking for F's. As both the loop counter and the array indexes start from 0, they are always equal and the same.
			if (poeng[c] >= 0 && poeng[c] <= 15) {
				//Print out the candidate's grade.
				System.out.println("Kandidatnummer " + c + " : F");
			} else if (poeng[c] >= 16 && poeng[c] <= 17) { //E's
				System.out.println("Kandidatnummer " + c + " : E");
			} else if (poeng[c] >= 18 && poeng[c] <= 22) { //D's
				System.out.println("KKandidatnummer " + c + " : D");
			} else if (poeng[c] >= 23 && poeng[c] <= 30) { //C
				System.out.println("Kandidatnummer " + c + " : C");
			} else if (poeng[c] >= 31 && poeng[c] <= 35) { //B
				System.out.println("KKandidatnummer " + c + " : B");
			} else if (poeng[c] >= 36 && poeng[c] <= 40) {//A
				System.out.println("Kandidatnummer " + c + " : A");
			} else { //Or if the points are NOT within the 0 to 40 scale, give an error.
				System.out.println("Kandidatnummer " + c + " : ERROR - Karakter ikke paa skala.");
			}
			//And increase the loop counter.
			c++;
		}
	}
}