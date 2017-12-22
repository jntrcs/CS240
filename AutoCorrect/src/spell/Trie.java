package spell;

public class Trie implements ITrie {

	private Node root;
	private int nodeCount;
	private int wordCount;
	
	public Trie() {
		root = new Node();
		nodeCount=1;//ROOT
		wordCount=0; //no words
		// TODO Auto-generated constructor stub
	}
	
	private int a = (int)'a';
	
	public void add(String word) {
		// TODO Auto-generated method stub
		Node current = root;

		for (int i=0; i<word.length(); i++)
		{
			char letter= word.charAt(i);
			int entry = (int)letter;
			entry=entry-a;
			Node entryNode=current.getNode(entry);
			if (entryNode==null)
			{
				entryNode=current.setNode(entry);
				nodeCount++;
			}
			current =entryNode;
		}
		current.incrementCount();
		if (current.getValue()==1)
			wordCount++;
		return;
	}
	
	public int search(String word)
	{
		if (find(word)!=null)
			return find(word).getValue();
		else
			return 0;
	}

	public INode find(String sword) {
		String word = sword.toLowerCase();
		Node current=root;
		for (int i=0; i<word.length(); i++)
		{
			char letter= word.charAt(i);
			int entry = (int)letter;
			entry=entry-a;
			if (current!=null)
			current=current.getNode(entry);
			else
				return null;
		}
			
		if (current==null)
			return null;
		// TODO Auto-generated method stub
		if (current.getValue()>0)
		return current;
		else return null;
	}

	public int getWordCount() {
		// TODO Auto-generated method stub
		return wordCount;
	}

	public int getNodeCount() {
		// TODO Auto-generated method stub
		return nodeCount;
	}
	
	@Override
	public String toString()
	{
		
		StringBuilder word=new StringBuilder();
		StringBuilder output = new StringBuilder();
		toStringHelper(root, word, output);
		return output.toString();
	}

	private void toStringHelper(Node n, StringBuilder word, StringBuilder output) //recursive
	{//word represents HIS word
		if (n==null)
			return;
		if (n.getValue()>0)
			output.append(word.toString() +"\n");

		for (int i = 0; i<26; i++)
		{
			toStringHelper(n.getNode(i), word.append((char)('a'+(char)i)), output); //possible casting needed
			word.setLength(word.length()-1); //chop off last character
		
		}

	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nodeCount;
		result = prime * result + wordCount;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trie other = (Trie) obj;
		if (nodeCount != other.nodeCount)
			return false;
		if (wordCount != other.wordCount)
			return false;
		return traverse(this, other);
	}
	
	public static boolean traverse(Trie one, Trie two)
	{
		return traverserecurse(one.root, two.root);
	}
	
	public static boolean traverserecurse(Node one, Node two)
	{
		if (one==null && two==null)
			return true;
		else if (one==null || two==null)
			return false;
		else if (one.getValue()!=two.getValue())
			return false;
		else 
		{
			boolean returnvalue=true;
			for (int i = 0; i<26; i++)
			{
				returnvalue=traverserecurse(one.getNode(i), two.getNode(i));
				if (!returnvalue)
					return returnvalue;
			}
			return returnvalue;
	}

}
	public class Node implements INode
	{
		private int count;
		private Node[] nextnodes;
		public Node()
		{
			nextnodes = new Node[26];
			count=0;
			
		}
		public void incrementCount()
		{
			count++;
		}

		public Node setNode(int i)
		{
			nextnodes[i]= new Node();
			return nextnodes[i];
		}
		public Node getNode(int i)
		{
			return nextnodes[i];
		}
		public int getValue() {
			// TODO Auto-generated method stub
			return count;
		}
		
	}
}
