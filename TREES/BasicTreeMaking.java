public class Node {

	int data;
	Node left,right;
	
	Node(int dat){
		data = dat;
		left= null;
		right = null;
		
	}

}

class BinaryTree{
	
	Node root;
	
	public BinaryTree() {
		root = null;
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTree(int key) {
		
		root = new Node(key);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.root = new Node(12);
		
		b.root.left = new Node(42);
		b.root.right = new Node(30);
		b.root.left.left = new Node(19);
		
	}
}
