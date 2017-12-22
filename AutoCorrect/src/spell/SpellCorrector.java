package spell;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;

import javax.xml.soap.Node;

public class SpellCorrector implements ISpellCorrector {

	public SpellCorrector() {
		// TODO Auto-generated constructor stub
	}
	
	private Trie dictionary;
	
	public void useDictionary(String dictionaryFileName) throws IOException {
		// TODO Auto-generated method stub
	    Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(dictionaryFileName)));
    	dictionary=new Trie();
	    do
	    {
	    	String next = sc.next();
	    	if (isWord(next))
	    		dictionary.add(next);
	    } while (sc.hasNext());
	    sc.close();
	    System.out.println(dictionary.getWordCount());
	    System.out.println(dictionary.getNodeCount());
	    System.out.println(dictionary.search("jesus"));
	}
	
	public boolean isWord(String potential)
	{
	
		for (int i = 0; i<potential.length(); i++)
		{
			if (!Character.isLetter(potential.charAt(i)))
			return false;
		}
		return true;
	}

	public String suggestSimilarWord(String inputWord)
			throws NoSimilarWordFoundException {
		// TODO Auto-generated method stub
		String word=inputWord.toLowerCase();
		
		if (dictionary.search(word)!=0)//for case WORD IN DICTIONARY
			return word;
		Set<String> allchange1 = new HashSet<String>();
		
		deletes(word, allchange1);
		insertion(word, allchange1);
		transpose(word, allchange1);
		change(word, allchange1);
		
		String suggestion=determineWinner(allchange1);
		if (suggestion!=null)
			return suggestion;
			
		Set<String> allchange2 =new HashSet<String>();
		for (String temp: allchange1)
		{
			deletes(temp, allchange2);
			insertion(temp, allchange2); //For changing letter use StringBuilder.setCharAt()
			transpose(temp, allchange2);
			change(temp, allchange2);
		}
		String suggestion2=determineWinner(allchange2);
		if (suggestion2==null)
			throw new NoSimilarWordFoundException();
		return suggestion2;
	}
	
	public void change(String word, Set<String> set)
	{
		StringBuilder wrd = new StringBuilder(word);
		for (int i = 0; i<word.length();i++)
		{
			
			for (int j=0; j<26; j++)
			{
				char t =(char) ((char)j+'a');
				if (t!=wrd.charAt(i))
					{
					StringBuilder changed = new StringBuilder(wrd);
					changed.setCharAt(i, t);
					set.add(changed.toString());
					}
					
			}
		}
			
	}
	
	public void transpose(String word, Set<String> set)
	{
		for (int i = 0; i<word.length()-1; i++)
		{
			String switched = transposeletters(i, word);
			set.add(switched);
		}
	}
	
	public String transposeletters(int letter, String word)
	{
		StringBuilder answer = new StringBuilder();
		if (letter!=0)
		{
			answer.append(word.substring(0, letter));
			answer.append(word.charAt(letter+1));
			answer.append(word.charAt(letter));
			answer.append(word.substring(letter+2));
		}
		else
		{
			answer.append(word.charAt(1));
			answer.append(word.charAt(0));
			answer.append(word.substring(2));
		}
		return answer.toString();
	}
	public void insertion(String word, Set<String> set)
	{
		for (int i = 0; i<=word.length(); i++)
		{
			for (int j = 0; j<26; j++)
			{
				String added = add(i, j, word);
				set.add(added);
			}
		}
	}
	
	public String add(int where, int letter, String word)
	{
		String one = word.substring(0, where);
		String two = word.substring(where);
		letter = letter+(int)'a';
		char realletter = (char)letter;
		return one+realletter+two;
	}
	
	public String determineWinner(Set<String> allchange1)
	{
		Set<String> realwords = new HashSet<String>();
		int highestFound=0;
		  for (String temp : allchange1) {
		        int found=dictionary.search(temp);
		        if (found>0)
		        {
		        	realwords.add(temp);
		        	if (found>highestFound)
		        		highestFound=found;
		        }
		        	
		     }
		  if (!realwords.isEmpty())
		  {
			  if (realwords.size()==1)
				  return realwords.iterator().next();
			  
			  Set<String> winners = new HashSet<String>();
			  for (String temp: realwords) {
				  if (dictionary.search(temp)==highestFound)
				  {
					  winners.add(temp);			  
				  }
			  }
			  String leastWord;
			  if (winners.size()==1)
				return winners.iterator().next();
			  else //event of ties in dictionary count
			  {
				 leastWord= winners.iterator().next();
				 for (String temp: winners)
				 {
					 if (temp.compareTo(leastWord)<0)
						 leastWord=temp;
				 }
				 return leastWord;
			  }
		  }
		  return null;
	}
	
	public void deletes(String word, Set<String> set)
	{
		for (int i = 0; i<word.length(); i++)
		{
			String removed = removedLetter(word, i);
			set.add(removed);
		}
	}
	
	public String removedLetter(String word, int charat)
	{
		String one = word.substring(0, charat);
		String two = word.substring(charat+1);
		return one+two;

	}

}
