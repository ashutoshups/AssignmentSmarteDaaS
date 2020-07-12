package QuestionTwo;

import java.util.Arrays;

class Card {

	//Spades = S, Hearts = H, Diamonds = D, Clubs = C
	public static final String[] SUITS  = {"S", "H", "D", "C"};

	//0th element will get used, so marking it as null.
	public static final String[] RANKS = {null, "#A", "#2", "#3", "#4", "#5", "#6","#7", "#8", "#9", "#10", "#J", "#Q", "#K"}; 

	public final static int A = 1, J = 11, Q = 12, K = 13;
	public final static int S = 1, H = 2, D = 3, C = 4;


	public boolean checkSequence(String cards) {
		String removeChar = cards.replace("#", "");
		if(removeChar.contains("Q")&& removeChar.contains("K")&& removeChar.contains("A")) {
			removeChar = removeChar.replace("A", "14");
		}
		else {
			removeChar = removeChar.replace("A", "1");
		}
		if (cards.contains("J")) {
			removeChar = removeChar.replace("J", "11");
		}
		if (cards.contains("Q")) {
			removeChar = removeChar.replace("Q", "12");
		}
		if (cards.contains("K")) {
			removeChar = removeChar.replace("K", "13");
		}
		if(removeChar.contains("Q")&& removeChar.contains("K")&& removeChar.contains("A")) {
			removeChar = removeChar.replace("A", "14");
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
			if(cardValue[i].contains("S"))
				numberArray[i] = Integer.parseInt(cardValue[i].replace("S", "1"));
			else if(cardValue[i].contains("H"))
				numberArray[i] = Integer.parseInt(cardValue[i].replace("H", "2")) ;
			else if(cardValue[i].contains("D"))
				numberArray[i] = Integer.parseInt(cardValue[i].replace("D", "3"));
			else if(cardValue[i].contains("C"))
				numberArray[i] = Integer.parseInt(cardValue[i].replace("C", "4"));
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
		String cardsInput1 = "H#A,H#2,H#3,H#4,"; // true
		String cardsInput2 = "S#10,S#J,S#Q,"; //true
		String cardsInput3 = "C#Q,C#K,C#A,C#2,"; // false
		String cardsInput4 = "D#5,D#6,H#7,"; // false
		card.checkSequence(cardsInput1);
		card.checkSequence(cardsInput2);
		card.checkSequence(cardsInput3);
		card.checkSequence(cardsInput4);
	}
}
