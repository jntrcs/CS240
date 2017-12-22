package hangman;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HangmanGame implements IEvilHangmanGame {

	public HangmanGame() {
		length = 0;
	    currentSet = new HashSet<String>();
	    alreadyGuessed=new TreeSet<Character>();
	    guessesLeft=0;
	}

	private int length;
	private Set<String> currentSet;
	private Set<Character> alreadyGuessed;
	private int guessesLeft;
	private Board board;

	@Override
	public void startGame(File dictionary, int wordLength) {
		// TODO Auto-generated method stub
		length = wordLength;
		board = new Board(length);
		Scanner sc;
		guessesLeft=10; //will need to fix this when I figure out how
	    try {
		sc = new Scanner(new BufferedInputStream(new FileInputStream(dictionary)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Invalid File");
			return;
		}
	    while (sc.hasNext())
	    {
	    	String word = sc.next();
	    	if (word.length()==length)
	    		{
	    		//System.out.println(word);
	    		currentSet.add(word);
	    		}
	    }
	    sc.close();
	    return;
	    
	}
	
	@Override
	public Set<String> makeGuess(char gues) throws GuessAlreadyMadeException {
		char guess=Character.toLowerCase(gues);
		if (alreadyGuessed.contains(guess))
			{throw new GuessAlreadyMadeException();
			}
		
		alreadyGuessed.add(guess);
		Map<String, Set<String>> subsets = new HashMap<String, Set<String>>();
		for (String word: currentSet)
		{
			String pattern = makePattern(word, guess);
			if (subsets.containsKey(pattern))
				//add word to existing key
			{
				Set<String> subset = subsets.get(pattern);
				subset.add(word);
				subsets.put(pattern, subset); //this may be highly inefficient
			}
			else //add key and value
			{
				Set<String> subset = new HashSet<String>();
				subset.add(word);
				subsets.put(pattern, subset);
			}
		}
		
		//need to iterate over map and find biggest subset, and return it.
		Set<String> newSet= findPartition(subsets, guess);
		currentSet=newSet;
		System.out.println(currentSet.size());
		return currentSet;
		
	}
	
	public Set<String> findPartition(Map<String, Set<String>> map, char guess)
	{
		Set<String> allkeys = map.keySet();
		int biggestSet =0;
		Set<Set<String>> contenders = new HashSet<Set<String>>();
		for (String temp:allkeys)
		{
			if (map.get(temp).size()>biggestSet)
			{
				contenders.clear();
				contenders.add(map.get(temp));
				biggestSet=map.get(temp).size();
			}
			else if (map.get(temp).size()==biggestSet)
			{
				contenders.add(map.get(temp));
			}
		}
		if (contenders.size()==1)
		{
			return contenders.iterator().next();			
		}
		else if(contenders.size()>1)
			return tiebreaker(contenders, guess);
		else
		{
			System.out.println("No partitions had any words");
			return null;
		}
	}
	
	public Set<String> tiebreaker(Set<Set<String>> contenders, char guess)
	{
		int lowestcount=500;
		Set<Set<String>> subsetc = new HashSet<Set<String>>();
		Set<String> allpatterns = new HashSet<String>();

		for (Set<String> temps: contenders)
		{
			String pattern =makePattern(temps.iterator().next(), guess);
			int stars = countStars(pattern);
			if (stars<lowestcount)
			{
				allpatterns.clear();
				allpatterns.add(pattern);
				lowestcount=stars;
				subsetc.clear();
				subsetc.add(temps);
			}
			else if (stars==lowestcount)
				{subsetc.add(temps);
				allpatterns.add(pattern);
				}
			}
		if (subsetc.size()==1)
		{
			return subsetc.iterator().next();
		}
		else
		{
			int farthestright=0;
			int counter = 0;
			while (counter<100)
			{
				farthestright=0;
				counter++;
				int numberofties=0;
				String winningpattern = new String();
			for (String pat: allpatterns)
			{
				int farright=0;
				int matched = 0;
				for (int i=pat.length()-1; i>=0; i--)
				{
					if(pat.charAt(i)=='*')
						{
							matched++;
							if (matched==counter)
								farright=i;
						}
				}
				if (farright>farthestright)
				{
					farthestright=farright;
					numberofties=1;
					winningpattern=pat;
				}
				else if(farright==farthestright)
					numberofties++;
			} 
			if (numberofties==1)
			{
				return findSet(winningpattern, subsetc, guess);
			}		
				System.out.println("The infinite loop continues");
			}
		}
		return null;
	}
	
	public Set<String> findSet(String pat, Set<Set<String>> sets, char guess)
	{
		for (Set<String> temp: sets)
		{
			System.out.println(temp.iterator().next());
			if (makePattern(temp.iterator().next(), guess).equals(pat))
			{
				return temp;
			}
		}
		System.out.println("Winning pattern not found");
		return null;
	}
	
	public int getGuesses()
	{return guessesLeft;}
	
	
	public static int countStars(String pattern)
	{
		int count = 0;
		for (int i=0; i<pattern.length(); i++)
		{
			if (pattern.charAt(i)=='*')
				count++;
		}
		return count;
	}
	
	public static String makePattern(String word, char guess)
	{
		StringBuilder pat = new StringBuilder();
		for (int i = 0; i<word.length(); i++)
		{
			if (word.charAt(i)==guess)
				pat.append('*');
			else
				pat.append("_");
		}
		return pat.toString();
	}
	
	public int getSetSize()
	{
		return currentSet.size();
	}
	
	public String getBoard()
	{
		StringBuilder board = new StringBuilder();
		String sampleword=currentSet.iterator().next();
		for (int i = 0; i<sampleword.length(); i++)
		{
			if (alreadyGuessed.contains(sampleword.charAt(i)))
			{
				board.append(sampleword.charAt(i));
				board.append(" ");
			}
			else
				board.append("_ ");
		}
		return board.toString();
	}
	
	public void runGame(int numguesses) throws GuessAlreadyMadeException
	{
		guessesLeft=numguesses;
		while (getGuesses()>0)
		{
			board.printBoardScreen(this);
			if (board.getLetterAdded())
			{
				System.out.println("Yes there are "+ board.count()+" " +board.getLatestGuess() + "s");

			}
			else
			{
				System.out.println("Sorry there are no " + board.getLatestGuess()+"s");
				guessesLeft--;
			}
			if (!getBoard().contains("_"))
			{
				System.out.println("You win! The word was "+currentSet.iterator().next());
				return;
			}
		}
			System.out.println("Sorry, you lose. The word was "+currentSet.iterator().next());
		
		return;
	}
	
	public boolean alreadyChosen(char s)
	{
		if (alreadyGuessed.contains(s))
			return true;
		else
			return false;
	}
	
	public String getGuessed()
	{
		StringBuilder string = new StringBuilder();
		for (char c: alreadyGuessed)
		{
			string.append(c);
			string.append(" ");
		}
		return string.toString();
	}
	
	public static boolean validargs(String[] args)
	{
		if (args.length!=3)
		{
			return false;
		}
		return true;
	}

	public static void main(String[] args)
	throws GuessAlreadyMadeException {
		// TODO Auto-generated method stub
		if(!validargs(args))
		{
			System.out.println("Usage: java HangmanGame dictionarytextfile #lettersinword #guesses");
		}
		HangmanGame g = new HangmanGame();
		g.startGame(new File(args[0]), Integer.valueOf(args[1]));
		g.runGame(Integer.valueOf(args[2]));
		//System.out.println(g.currentSet);
		//g.makeGuess('m');
		//System.out.println(g.makeGuess('r'));
		//System.out.println(g.makeGuess('i'));

	}

}
