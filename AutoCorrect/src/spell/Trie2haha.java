package spell;

public class Trie2haha implements ITrie {

	int nodeCount;
	int wordCount;
	Node root;
	
	public Trie2haha() {
		// TODO Auto-generated constructor stub
		root=new Node();
		nodeCount=1;
		wordCount=0;
	}

	@Override
	public void add(String word) {
		// TODO Auto-generated method stub
		Node currentNode = root;
		int a=(int)'a';
		for (word)
		{
			entry=getNode(charat-a)
					if null set it
					update current
					
		}
		increment current value
		if ==1 
		increment wordcount
	}
	
	hashcode
	(autogenerate)
	equals()
	auto generate then call recursive(root, root)
	
	traverserecurse()
	if (null null)
		true
		else if null or null
		false
		for (26)
			traverserecurse(get(i));

	@Override
	public INode find(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWordCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNodeCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public class Node implements INode
	{
		int value;
		Node[] children;
		Node()
		{
			value=0;
			children = new Node[26];
		}
		@Override
		public int getValue() {
			// TODO Auto-generated method stub
			return 0;
		}
		incrementcount();
		setChild(int i);
		getchild(int i);
		
	}

}
