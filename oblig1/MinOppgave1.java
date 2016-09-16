/*
A Quiz Software.
I decided to make a simple quiz software, that asks a few questions, checks the answers, and then gives a score.

This uses quite a bit of stuff we haven't been though in lectures, simply because I have programming experience so I decided to make it a bit harder for myself.
*/

//Scanner
import java.util.Scanner;

//Create class and main as per ususal.
class MinOppgave1 {
	//In this program, main doesn't contain much of the code, but serves as a kind of wrapper, keeping everything together. Keeping the program running.
	public static void main (String [] args) {
		//A loop, this means that regardless of how many times you play, the game won't exit iself until you tell it to.
		//Instead, it will simply start from the top and show you the main menu when you finish.
		while (true) {
			//Call the main menu function, which returns an int telling the program what to do.
			int whatToDo = mainMenu();

			// RETURN CODES:
			// 1 - run game
			// 2 - quit
			// 3 - invalid input
			//If user entered start, run the game.
			if (whatToDo == 1) {
				playGame();
			}
			if (whatToDo == 2) {
				System.out.println("Bye.");
				//Remember how I said it won't quit until you tell it to? break stops the loop, in this case ending the software.
				break;
			}
		}
	}

	//Making a simple main menu thing.
	//The main menu function returns a number which tells the main function what to do.
	static int mainMenu () {
		Scanner input = new Scanner(System.in);

		//Skip a line then print the menu text.
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("WELCOME TO THE QUIZ");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("Type one of the following commands to continue:");
		System.out.println("start - Start the quiz");
		System.out.println("quit - Quit this game");
		System.out.println("");

		//Adding a letter to the start of the line to highlight the user input. Print doesn't make a new line, allowing the user to write on the same line.
		System.out.print("> ");
		//Accept command input.
		String in = input.nextLine();

		//Check if the string is equal to a command, ignore upper and lowercase letters.
		if (in.equalsIgnoreCase("start")) {
			//return 1, the int code to start the game.
			return 1;
		}

		if (in.equalsIgnoreCase("quit")) {
			//return 2, the int code to quit the game.
			return 2;
		}
		//If the input is either start or quit, this function/method will have stopped running by now. If not, let's stop it manually, throwing an error return code.
		return 3;
	}

	//Making the function that runs the game itself.
	static void playGame () {
		Scanner input = new Scanner(System.in);

		//Define the score variable.
		int score = 0;

		System.out.println("For each question - enter the character associated with your answer.");
		//Ask the question and tell the possible options.
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("QUESTION 1:");
		System.out.println("What programming language is this game made in?");
		System.out.println("A: Java"); //Should be obvious based on the cmd used to run it.
		System.out.println("B: C++");
		System.out.println("C: Python");
		//Use the method/function to accept an answer, telling it which answer is correct.
		if (acceptAnswer("a") == true) {
			//If the user answers correct, increase the score by 1, then move on.
			score++;
		}
		//If the user answers incorrectly, just move on.
		//Repeat for all 5 questions:
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("QUESTION 2:");
		System.out.println("Which company develops Java today?");
		System.out.println("A: Adobe");
		System.out.println("B: Oracle"); //Correct.
		System.out.println("C: Google"); //Uses Java for Android, doesn't develop Java itself.
		if (acceptAnswer("b") == true) {
			score++;
		}
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("QUESTION 3:");
		System.out.println("What is one of the major benefits of Java?");
		System.out.println("A: Java doesn't need to compile."); //It does.
		System.out.println("B: Java can run on many operating systems."); //Correct.
		System.out.println("C: Java can be run without installing anything."); //Needs to install Java itself.
		if (acceptAnswer("b") == true) {
			score++;
		}
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("QUESTION 4:");
		System.out.println("Which of the following is correct:");
		System.out.println("A: system.out.println(\"Hello World\");"); //Needs capital S.
		System.out.println("B: System.out.println(\"Hello World\")"); //Needs ;
		System.out.println("C: System.out.println(\"Hello World\");"); //Correct.
		if (acceptAnswer("c") == true) {
			score++;
		}
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("QUESTION 5:");
		System.out.println("What was the original name for Java?");
		System.out.println("A: Java");
		System.out.println("B: Simula");
		System.out.println("C: Oak"); // https://en.wikipedia.org/wiki/Java_(programming_language)#History
		if (acceptAnswer("c") == true) {
			score++;
		}

		//Output the users score in the end.
		System.out.println("");
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
		System.out.println("");
		System.out.println("YOUR SCORE: " + score + " points.");
		System.out.println("Congratulations");
		System.out.println("");

	}

	//Since I repeat the code to accept player input quite a lot, and it's annoying to write again and again, here it is in it's own function.
	//Accept the correct answer letter as a method/function parameter.
	//Return true if the user should get a point (was right), or false if not.
	static boolean acceptAnswer (String correctAnswer) {
		Scanner input = new Scanner(System.in);

		//And a loop, so I can easily let the user answer again if their input is invalid.
		while (true) {
			//Again, add a character before the user input to highlight.
			System.out.print("> ");
			//And accept user input, in this case their answer.
			String in = input.nextLine();

			//Check if user input is equal to the correct answer, ignoring upper/lowercase.
			if (in.equalsIgnoreCase(correctAnswer)) {
				//Return true, telling the game function the answer was correct. Also ending this function (for now).
				return true;
			}
			//Checks if it is a valid answer, regardless of whether it is correct. If it is a OR b OR c.
			if (in.equalsIgnoreCase("a") || in.equalsIgnoreCase("b") || in.equalsIgnoreCase("c")) {
				//If it is a valid answer, end the function here, telling the game the given answer was wrong.
				return false;
			}
			//If it is an invalid answer, give another chance to answer. (using the loop.)
		}
	}
}