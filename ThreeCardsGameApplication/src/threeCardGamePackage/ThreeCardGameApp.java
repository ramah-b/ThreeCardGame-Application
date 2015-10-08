package threeCardGamePackage;

import java.util.Scanner;

public class ThreeCardGameApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String quitKeyword = "";
		double betAmount;
		int userChoice;

		// print the opening message to the console
		System.out
				.println("You slide up to Fast Eddie's card table and plop down your cash. ");
		System.out
				.println("He glances at you out of the corner of his eye and starts shuffling.");
		System.out.println("He lays down three cards.\n\n");

		// create an object of to start the game
		ThreeCardsGame newGame = new ThreeCardsGame();

		System.out.print("How much money do you have for this game? ");
		newGame.setCashMoney(keyboard.nextInt());
		System.out.println();

		// reads the user's bet amount and make sure it is !< 5
		do {
			System.out
					.print("How much would you like to bet? (minimum $5, maximum 500) ");
			betAmount = keyboard.nextDouble();
			while (betAmount < 5 || betAmount >= 500) {
				System.out
						.print("Cannot bet this much. How much would you like to bet? ");
				betAmount = keyboard.nextDouble();
			}
			// check that the user actually has a sufficient amount in his
			// wallet to make this bet and start the game (shuffle cards and lay
			// them out
			if (newGame.updateCurrentBetAmount(betAmount)) {
				newGame.shuffleCards();
				System.out.println(newGame.layCards());

				// reads the user guessed number and make sure it is between 1-3
				userChoice = keyboard.nextInt();
				while (userChoice > 3 || userChoice < 1) {
					System.out
							.print("you should choose one of the three cards (1-3): ");
					userChoice = keyboard.nextInt();
				}
				System.out.println("\n");

				// check the user's guess and print out the result
				System.out.println(newGame.checkUserGuess(userChoice));

				// asks if the user want to keep guessing
				System.out.print("quit ('y' or 'n')? ");
				quitKeyword = keyboard.next().toLowerCase();
			}
			// if the user has insufficient amount then end the game
			else {
				System.out
						.println("You don't have enough money in you wallet.");
				System.out
						.println("You are not allowed to bet or play this game anymore.");
				System.out.println("The game is over!");
				System.out.println();
				quitKeyword = "y";
			}
		} while (!quitKeyword.equals("y"));

		System.out.println(newGame.printHistory());

		keyboard.close();

	}

}
