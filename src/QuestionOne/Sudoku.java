package QuestionOne;

public class Sudoku {
	private static final int BOARD_SIZE = 8;
	private static final int MIN_VALUE = 0;

	public static int[][] board = {

			{ 8, 0, 0, 0, 0, 0, 0, 0, 0 },  //0
			{ 0, 0, 3, 6, 0, 0, 0, 0, 0 },  //1
			{ 0, 7, 0, 0, 9, 0, 2, 0, 0 },  //2
			{ 0, 5, 0, 0, 0, 7, 0, 0, 0 },  //3
			{ 0, 0, 0, 0, 4, 5, 7, 0, 0 },  //4
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 },  //5
			{ 0, 0, 1, 0, 0, 0, 0, 6, 8 },  //6
			{ 0, 0, 8, 5, 0, 0, 0, 1, 0 },  //7
			{ 0, 9, 0, 0, 0, 0, 4, 0, 0 }   //8 
	};

	public static void main (String[] args)
	{
		if(sudokuCheck(board, 4, 4, 1)==true)
			System.out.println("True");
		else
			System.out.println("False");
	}
	public static boolean sudokuCheck(int[][] s, int rowOfSudoku, int columnOfSudoku, int numberToPlace)
	{
		for(int row = rowOfSudoku; row <= rowOfSudoku; row++) {
			for (int column = MIN_VALUE; column <= BOARD_SIZE; column++) {
				for(int col2 = column + 1; col2 < BOARD_SIZE; col2++) {
					if(numberToPlace==s[row][col2]) {
						return false;
					}
					else {
						continue;
					}

				}
			}
		} 
		for(int col = columnOfSudoku; col <= columnOfSudoku; col++) {
			for(int row = MIN_VALUE; row < 8; row++) {
				for(int row2 = row + 1; row2 < BOARD_SIZE; row2++) {
					if(numberToPlace==s[row2][col]) {
						return false;
					}
					else {
						continue;
					}
				}
			}
		}
		return true;    
	}
}
