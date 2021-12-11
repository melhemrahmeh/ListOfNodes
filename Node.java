public class Node {
	public char data;
	public Node next;
	
	public Node(char data) {
		this.data = data;
	}
	public Node(char data, Node next) {
		this(data);
		this.next = next;
	}
}