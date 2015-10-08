package threeCardGamePackage;

import java.util.Random;

public class ThreeCardsGame {

	private int selectedCard; // stores where the ace card is
	private double cashMoney;
	private double betAmount;

	public ThreeCardsGame() {
		this.selectedCard = 0;
		this.cashMoney = 100;
		this.betAmount = 0;
	}

	public int getSelectedCard() {
		return selectedCard;
	}

	public void setSelectedCard(int selectedCard) {
		this.selectedCard = selectedCard;
	}

	public double getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(double cashMoney) {
		this.cashMoney = cashMoney;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	// shuffle the cards: draws a random number (1-3) and sets it to the
	// selectedNum attribute
	public void shuffleCards() {

		Random r = new Random();

		int newCard = 1 + r.nextInt(3);

		this.setSelectedCard(newCard);
	}

	public boolean updateBetAmount(double betAmount) {

		if (this.cashMoney < betAmount || this.betAmount >= 500)
			return false;
		else {
			this.betAmount += betAmount;
			this.cashMoney -= betAmount;
			return true;
		}
	}

	// prints out the simulated graphics
	public void layCards() {

		System.out.println("Which one is the ace?\n\n");
		String str = String.format("%s %s %s %s", "\t", "##", "##", "##");

		System.out.println(str);
		System.out.println(str);

		System.out.printf("%s %s %s %s", "\t", "1 ", "2 ", "3 ");
		System.out.println("\n\n");

	}

	// checks if the user guessed correctly
	public void checkUserPick(int userChoice) {

		if (userChoice == this.getSelectedCard()) {
			System.out
					.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
			this.showCards(getSelectedCard());
		} else {
			System.out
					.println("Ha! Fast Eddie wins again! The ace was card number "
							+ this.getSelectedCard() + ".");
			this.showCards(getSelectedCard());
		}
	}

	// prints out the simulated graphics after the user's guess
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
