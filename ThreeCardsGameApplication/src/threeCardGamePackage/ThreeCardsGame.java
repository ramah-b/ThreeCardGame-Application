package threeCardGamePackage;

import java.util.Random;

public class ThreeCardsGame {

	private int selectedCard;

	public ThreeCardsGame() {
		this.selectedCard = 0;
	}

	public int getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(int selectedCard) {
		this.selectedCard = selectedCard;
	}

	public void shuffleCards() {

		Random r = new Random();

		int newCard = 1 + r.nextInt(3);

		this.setSelectedCard(newCard);
	}

	public void layCards() {

		System.out.println("Which one is the ace?\n\n");
		String str = String.format("%s %s %s %s", "\t", "##", "##", "##");

		System.out.println(str);
		System.out.println(str);

		System.out.printf("%s %s %s %s", "\t", "1 ", "2 ", "3 ");
		System.out.println("\n\n");

	}

	public void checkUserPick(int userChoice) {

		if (userChoice == this.getSelectedCard()) {
			System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
			this.showCards(getSelectedCard());
		} else{
			System.out.println("Ha! Fast Eddie wins again! The ace was card number " + this.getSelectedCard() + ".");
			this.showCards(getSelectedCard());
		}
	}

	public void showCards(int userChoice) {

		String str;

		if (userChoice == 1)
			str = String.format("%s %s %s %s", "\t", "AA", "##", "##");
		else if (userChoice == 2)
			str = String.format("%s %s %s %s", "\t", "##", "AA", "##");
		else
			str = String.format("%s %s %s %s", "\t", "##", "##", "AA");

		System.out.println(str);
		System.out.println(str);
		System.out.printf("%s %s %s %s", "\t", "1 ", "2 ", "3 ");
		System.out.println("\n\n");

	}

}
