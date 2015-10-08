package threeCardGamePackage;

import java.util.Scanner;

public class ThreeCardGameApp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		String quitKeyword = "";
		double betAmount;
		int userChoice;

		System.out
				.println("You slide up to Fast Eddie's card table and plop down your cash. ");
		System.out
				.println("He glances at you out of the corner of his eye and starts shuffling.");
		System.out.println("He lays down three cards.\n\n");

		ThreeCardsGame newGame = new ThreeCardsGame();

		do {

			System.out
					.print("How much would you like to bet? (minimum is $5) ");
			betAmount = keyboard.nextDouble();

			while (betAmount < 5) {
				System.out
						.print("Insufficient bet amount. How much would you like to bet? ");
				betAmount = keyboard.nextDouble();
			}
			if (newGame.updateBetAmount(betAmount)) {
				newGame.shuffleCards();
				newGame.layCards();

				do {
					userChoice = keyboard.nextInt();

				} while (userChoice > 3 || userChoice < 1);
				System.out.println("\n");

				newGame.checkUserPick(userChoice);
				System.out.print("quit ('y' or 'n')? ");
				quitKeyword = keyboard.next().toLowerCase();
			} else {
				System.out
						.println("You are not allowed to bet or play this game anymore. The game is over!");
				quitKeyword = "y";
			}
		} while (!quitKeyword.equals("y"));
		System.out.println("Bye Bye!");

		keyboard.close();

	}

}
