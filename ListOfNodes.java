public class ListOfNodes {
	static Node head;

	public static void main(String[] args) {
		print();
		addFirst('e');
		print();
		addLast('l');
		print();
		addMiddle(0, 'H');
		print();
		addMiddle(count(), 'l');
		print();
		addLast('$');
		print();
		for (int i = 0; i < count(); i++) {
			set(i, (char) (65 + i));
		}

		print();

		for (int i = 0; i < count(); i++) {
			System.out.println(get(i));
		}
		print();
		addMiddle(2, 'C');
		print();
		addAfterFirstOccurrence('C', '$');
		print();
		addAfterFirstOccurrence('C', '$');
		print();
		addAfterLastOccurrence('C', 'X');
		print();
		addBeforeLastOccurrence('C', 'I');
		print();
		addBeforeLastOccurrence('$', '_');
		print();
		removeDuplicates();
		print();

		set(4,'C');
		set(6,'C');
		set(8,'C');
		print();
		int c = removeFirstOccurrence('C');
		print();
		System.out.println(c);

		c=removeLastOccurrence('C');
		print();
		System.out.println(c);
		while(count()>0) {
			c = removeLast();
			System.out.println((char)c);
			print();
		}

		boolean I = contains('I');
		System.out.println(I);
		boolean Y = contains('Y');
		System.out.println(Y);

		 while (count() > 0) {
		 	System.out.println(removeFirst());
		 }
		 print();

		 System.out.println("\n");
		 addAll(0,new char[]{'a','e','i','o','u'});
		 print();
		 addAll(2,new char[]{'a','e','i','o','u'});
		 print();
		 swapPairs();
		 print();
	}

	public static int count() {
		//return the number of nodes in the chain of nodes that starts at head
		Node current = head;
		int count = 0;
		if(head==null) {
			return 0;
		}
		else{
			while(current.next!=null) {
				count++;
				current = current.next;
			}
		count++;
		return count;
		}
	}

	public static void addFirst(char data) {
		//creates a new node, sets its data value, and makes it the first node in the chain
		head = new Node (data,head);

	}

	public static void print() {
		//returns all the elements (characters) of the node between square brackets [] followed by a comma then the number of nodes
		//ex: [hello],5
		Node current = head;
		if(head==null) {
			System.out.println("[],0");;
		}
		else {
			String s = "";
			while(current.next!=null) {
			s+=(current.data);
			current = current.next;
			}
			s+=(current.data);
			System.out.println("["+s+"],"+count());
		}
	}

	public static void addLast(char data) {
		//creates a new node, sets its data value, and adds data to the end of the chain
		Node node = head;
		Node last = new Node(data , null);
		if(head==null) {
			head = last;
		}
		else {
			while(node.next!=null) {
				node = node.next;
			}
			node.next = last;
		}
	}

	public static void addMiddle(int index, char data) {
		//creates a new node, sets its data value, and inserts it right after the node whose number in the chain is index
		Node new_node = new Node(data , null);
		if(index==0) {
			addFirst(data);
		}
		else{
			Node n = head;
			for(int i=0;i<index-1;i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;
		}
	}

	public static void set(int index, char data) {
		//changes the data value of the node located at position index
		Node current = head;
		int i = 0;
		while (current.next != null) {
			if (index == i) {
				current.data = data;
			}
			current = current.next;
			i++;
		}

		if (index == ListOfNodes.count() - 1)  {
			current.data = data;
		}
	}

	public static char get(int index) {
		//returns the char stored in the node located at position index
		Node current = head;
		int i = 0;
		while (current.next != null) {
			if (index == i) {
				return current.data;
			}
			current = current.next;
			i++;
			}

		if (index == ListOfNodes.count() - 1)  {
			return current.data;
		}
		else {
			return (char) -1;
		}
	}

	public static void addAfterFirstOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the first node whose data value is afterData
		Node current = head;
		Node new_node = new Node(data,null);
		while (current.next != null) {
			if (current.data == afterData) {
				new_node.next = current.next;
				current.next = new_node;
				break;
			}
			current = current.next;
		}
	}

	public static void addAfterLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it after the last node whose data value is afterData
		Node current=head;
		int i = 0;
		int last_index = 0;
		while(current.next!=null) {
			if(current.next.data == afterData) {
				last_index = i+1;
			}
			current=current.next;
			i++;
		}
		addMiddle(last_index+1,data);
	}

	public static void addBeforeLastOccurrence(char afterData, char data) {
		//creates a new node sets its data value to data, and inserts it before the last node whose data value is afterData
		Node current=head;
		int i = 0;
		int index = 0;
		while(current.next!=null) {
			if(current.next.data == afterData) {
				index = i+1;
			}
			current=current.next;
			i++;
		}
		addMiddle(index,data);
	}

	public static void clear() {
		//makes count() return zero
		head = null;
	}

	public static void removeDuplicates() {
		//removes all duplicate values of the chain
		Node node1 = head;
		Node node2;
		while (node1 != null && node1.next != null) {
			node2 = node1;
			while (node2.next != null) {

				if (node1.data == node2.next.data) {
					node2.next = node2.next.next;
				} else {
					node2 = node2.next;
				}
			}
			node1 = node1.next;
		}
	}


	public static char removeFirst() {
		//removes the first node in the chain
		if (head == null)
			return '\0';
		else {
			char c = head.data;
			Node node = head;
			head = node.next;
			return c;
		}
	}

	public static char removeLast() {
		if (head.next == null){
			char c = head.data;
			removeFirst();
			return c;
		}
		else {
			Node node = head;
			while (node.next.next!=null){
				node = node.next;
			}
			char e = node.next.data;
			node.next = null;
			return e;
		}
	}


	 public static int removeFirstOccurrence(char data) {
		 //removes the first node whose data value is data
		 Node node = head;
		 int i = 0;
		 int index = 0;
		 Node previous = null;
		 Node n = null;
		 while (node.next != null) {
			 if (node.next.data == data) {
				 previous = node;
				 index = i+1;
				 n = node.next.next;
				 break;
			 }
			 node = node.next;
			 i++;
		 }
		 assert previous != null;
		 previous.next = n;
		 return index;

	 }

	public static int removeLastOccurrence(char data) {
		//removes the last node whose data value is data
		Node current=head;
		Node previous=null;
		Node temp=null;
		int i = 0;
		int index = 0;
		while(current.next!=null) {
			if(current.next.data == data) {
				previous=current;
				temp=current.next;
				index = i+1;
			}
			current=current.next;
			i++;
		}
		assert previous != null;
		previous.next=temp.next;
		return index;
	}

	public static boolean contains(char data) {
		//returns true if any of the nodes in the chain contains data
		Node node = head;
		boolean state = false;
		if (head==null){
			return false;
		}
		else {
			while(node.next!=null) {
				if (node.data == data) {
					state = true;
					break;
				}
				node = node.next;
			}
			if (node.data == data){
				state = true;
			}
			return state;
		}
	}

	public static void addAll(int index, char[] chars) {
		//adds all characters in chars to the chain starting at position index
		Node node=head;
		if (node == null || node.next== null){
			for (int i = 0; i < chars.length; i++) {
				addLast(chars[i]);
			}
		}
		else{
			for (int i = 0; i < chars.length; i++) {
				addMiddle(index+i ,chars[i]);
			}
		}
	}

	public static void swapPairs(){
		//swaps element 0 with element 1, element 2 with element 3, element 4 with element 5, etc.
		//if the list has an odd number of elements, the the last element remains the same
		Node current = head;

		while (current != null && current.next != null) {
			char temp_data = current.data;
			current.data = current.next.data;
			current.next.data =  temp_data;
			current = current.next.next;
		}
	}
}