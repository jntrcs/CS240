package hangman;

import hangman.IEvilHangmanGame.GuessAlreadyMadeException;

import java.util.Scanner;

public class Board {

	private int wordlength;
	private String knownWord;
	private boolean letteradded;
	char latestGuess;
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int length)
	{
		wordlength=length;
	}
	
	public void printBoardScreen(HangmanGame g) throws GuessAlreadyMadeException
	{
		Scanner in = new Scanner(System.in);

		System.out.println("You have " +g.getGuesses() + " guesses left.");
		System.out.println("Letters guessed so far: ");
		System.out.println(g.getGuessed());
		knownWord = g.getBoard();
		System.out.println("The board looks like this: " + knownWord);
		System.out.println("Enter the letter you'd like to guess here: ");
		String s=in.nextLine();
		while (!validLetter(s))
		{
			System.out.println("Invalid Input");
			System.out.println("Please enter a character");
			s=in.nextLine();
		}
		while (g.alreadyChosen(Character.toLowerCase(s.charAt(0))))
		{
			System.out.println("You've already used that letter");
			System.out.println("Please enter a letter");
			s=in.nextLine();
		}
		//needs some validation
		letteradded=false;
		latestGuess =Character.toLowerCase(s.charAt(0));
		g.makeGuess(Character.toLowerCase(s.charAt(0)));
		if (g.getBoard().equals(knownWord))
		{
			letteradded=false;
		}
		else
		{
			letteradded=true;
			knownWord=g.getBoard();
		}
	}
	
	public boolean validLetter(String c)
	{
		if (c.length()!=1)
			return false;
		if (Character.isLetter(c.charAt(0)))
			return true;
		else 
			return false;
	}

	public boolean getLetterAdded()
	{
		return letteradded;
	}
	
	public char getLatestGuess()
	{
		return latestGuess;
	}
	
	public int count()
	{
		int count=0;
		for (int i = 0; i<knownWord.length(); i++)
		{
			if (getLatestGuess()==knownWord.charAt(i))
				count++;
		}
	return count;
	}
}

