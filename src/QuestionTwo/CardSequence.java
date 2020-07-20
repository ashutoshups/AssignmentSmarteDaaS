package QuestionTwo;

import java.util.Arrays;

class Card {

	public final static String A = "1", J = "11", Q = "12", K = "13", ACE_AFTER_KING = "14";
	public final static String S = "1", H = "2", D = "3", C = "4";
	
	//Spades = S, Hearts = H, Diamonds = D, Clubs = C
	public static final String SPADES = "S";
	public static final String HEARTS = "H";
	public static final String DIAMONDS = "D";
	public static final String CLUBS = "C";
	
	public static final String JACK = "J";
	public static final String QUEEN = "Q";
	public static final String KING = "K";
	public static final String ACE = "A";
	
	

	public boolean checkSequence(String cards) {
		String removeChar = cards.replace("#", "");
		if(removeChar.contains(QUEEN)&& removeChar.contains(KING)&& removeChar.contains(ACE)) {
			removeChar = removeChar.replace(ACE, ACE_AFTER_KING);
		}
		else {
			removeChar = removeChar.replace(ACE,A);
		}
		if (cards.contains(JACK)) {
			removeChar = removeChar.replace(JACK, J);
		}
		if (cards.contains(QUEEN)) {
			removeChar = removeChar.replace(QUEEN, Q);
		}
		if (cards.contains(KING)) {
			removeChar = removeChar.replace(KING, K);
		}
		
		String[] splitedCards = removeChar.split(",");
		int numberArray[] = new int[splitedCards.length];
		numberArray = convertIntoNumber(splitedCards);
		if(checkSequence(numberArray)) {
			System.out.println("True");
			return true;
		}
		else {
			System.out.println("false");
			return false;
		}
	}

	public int[] convertIntoNumber(String[] cardValue) {
		int numberArray[] = new int[cardValue.length];
		for (int i = 0; i < cardValue.length; i++) {
			if(cardValue[i].contains(SPADES))
				numberArray[i] = Integer.parseInt(cardValue[i].replace(SPADES, S));
			else if(cardValue[i].contains(HEARTS))
				numberArray[i] = Integer.parseInt(cardValue[i].replace(HEARTS, H)) ;
			else if(cardValue[i].contains(DIAMONDS))
				numberArray[i] = Integer.parseInt(cardValue[i].replace(DIAMONDS, D));
			else if(cardValue[i].contains(CLUBS))
				numberArray[i] = Integer.parseInt(cardValue[i].replace(CLUBS, C));
		}
		return numberArray;
	}

	public boolean checkSequence(int[] numberArray) {
		Arrays.sort(numberArray);
		for (int i = 0; i < numberArray.length - 1; i++) {
			if (numberArray[i] + 1 != numberArray[i + 1]) {
				return false;
			}
		}
		return true;
	}
}


public class CardSequence {

	public static void main(String[] args) {
		Card card = new Card();
		String cardsInputOne = "H#A,H#2,H#3,H#4,"; // true
		String cardsInputTwo = "S#10,S#J,S#Q,"; //true
		String cardsInputThree = "C#Q,C#K,C#A,C#2,"; // false
		String cardsInputFour = "D#5,D#6,H#7,"; // false
		card.checkSequence(cardsInputOne);
		card.checkSequence(cardsInputTwo);
		card.checkSequence(cardsInputThree);
		card.checkSequence(cardsInputFour);
	}
}
