package threeCardGamePackage;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class ThreeCardsGame {

	private int selectedCard; // stores where the ace card is
	private double cashMoney; //user's wallet of how much money he/she has
	private ArrayList<Double> betAmount = new ArrayList<Double>(); 
	private ArrayList<String> guessedCard = new ArrayList<String>();
	private static int playCounter;
	private double currentBetAmount; 
 
	public ThreeCardsGame() {
		this.selectedCard = 0;
		this.cashMoney = 0;
		ThreeCardsGame.playCounter = 0;
		currentBetAmount = 0;
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

	public double getPlayCounter() {
		return playCounter;
	}

	public static void setPlayCounter() {
		playCounter++;
	}

	// shuffle the cards: draws a random number (1-3) and sets it to the
	// selectedNum attribute
	public void shuffleCards() {

		Random r = new Random();

		int newCard = 1 + r.nextInt(3);

		this.setSelectedCard(newCard);
	}

	public boolean updateBetAmount(double betAmount) {

		//saves the user's betAmount and checks if the user has sufficient money in his wallet
		if (this.cashMoney < betAmount)
			return false;
		else {
			this.currentBetAmount = betAmount;
			this.betAmount.add(playCounter, betAmount);
			this.cashMoney -= betAmount;
			
			return true;
		}
	}

	// prints out the simulated graphics
	public String layCards() {

		String finalStr, str; 
		finalStr = "Which one is the ace?\n\n";
		str = String.format("%s %s %s %s", "\t", "##", "##", "##");

		finalStr+= (str + "\n" + str + "\n");
	

		str = String.format("%s %s %s %s", "\t", "1 ", "2 ", "3 ");
		finalStr += (str + "\n\n");

		return finalStr;
	}

	//saves the user's guess and checks if the user guessed correctly
	public String checkUserPick(Integer userChoice) {

		this.guessedCard.add(playCounter, userChoice.toString());
		ThreeCardsGame.setPlayCounter();
		
		String resultStr; 
		if (userChoice == this.getSelectedCard()) {
			this.cashMoney += currentBetAmount; 
		 resultStr = "You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n\n" + this.showCards(getSelectedCard());
		} else {
			 resultStr = "Ha! Fast Eddie wins again! The ace was card number "
							+ this.getSelectedCard() + ".\n\n" + this.showCards(getSelectedCard());
		}
		return resultStr;
	}

	// prints out the simulated graphics after the user's guess
	public String showCards(int userChoice) {

		String finalStr, str;

		if (userChoice == 1)
			str = String.format("%s %s %s %s", "\t", "AA", "##", "##");
		else if (userChoice == 2)
			str = String.format("%s %s %s %s", "\t", "##", "AA", "##");
		else
			str = String.format("%s %s %s %s", "\t", "##", "##", "AA");

		finalStr = str + "\n" + str +"\n";
		
		str= String.format("%s %s %s %s", "\t", "1 ", "2 ", "3 ");
		finalStr += str + "\n\n";
		
		return finalStr;

	}

	public String printHistory(){
		String historyStr;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		historyStr = "This is your Game History\n";
		
		for (int i= 0; i < this.getPlayCounter(); i++){
			historyStr += "Round# " + (i+1) + "\n";
			historyStr += "Bet " + currency.format(this.betAmount.get(i)) + "\n";
			historyStr += "Guessed Card " + this.guessedCard.get(i) + "\n";
			historyStr += "-------------------------\n\n";
			
		}
		historyStr += "You have " + currency.format(this.cashMoney) + " in your wallet.";
		return historyStr;
	}
}
