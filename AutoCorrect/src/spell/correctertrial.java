package spell;

import java.io.IOException;
import java.util.Scanner;

public class correctertrial implements ISpellCorrector {
	
	
	public correctertrial() {
		// TODO Auto-generated constructor stub
	}
	Trie dictionary;
	@Override
	public void useDictionary(String dictionaryFileName) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=buffered(input)
				String entery;
				while (sc.hasNext())
					dictionary.add(entry);
				entry=sc.next();
	}

	@Override
	public String suggestSimilarWord(String inputWord)
			throws NoSimilarWordFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
