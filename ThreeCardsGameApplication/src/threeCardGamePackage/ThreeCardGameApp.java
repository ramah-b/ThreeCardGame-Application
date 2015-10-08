package threeCardGamePackage;

import java.util.Scanner;

public class ThreeCardGameApp {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("You slide up to Fast Eddie's card table and plop down your cash. ");
		System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
		System.out.println("He lays down three cards.\n\n");
		
		ThreeCardsGame newGame = new ThreeCardsGame();
		
		newGame.shuffleCards();
		newGame.layCards();
		
		int userChoice = keyboard.nextInt();
		System.out.println("\n");
		
		newGame.checkUserPick(userChoice);
		
		keyboard.close();

	}

}
