
class Node {
    int data;     // Data stored in the node
    Node next;    // Reference to the next node

    public Node(int data) {
        this.data = data;   // Initialize node data
        this.next = null;   // Initialize the next node reference to null
    }
}

public class LinkedListPrimeDemo2 {
    private Node head;  // Head of the list

    // Constructor to initialize the linked list
    public LinkedListPrimeDemo2() {
        this.head = null;  // Initially, the list is empty
    }

    public void add(int val) {
    	Node node = new Node(val);
    	if(head == null) {
    		head = node;
    		return;
    	}
    	Node temp = head;
    	while(temp.next != null) {
    		temp = temp.next;
    	}
    	temp.next = node;
    }
    public void remove(int val) {
    	if(head == null) {
    		System.out.println("empty !!!");
    		return;
    	}
    	if(head.data == val) {
    		head = head.next;
    		return;
    	}
    	Node temp = head;
    	while(temp.next != null && temp.next.data != val) {
    		temp = temp.next;		
    	}
    	if(temp.next!=null) {
    		temp.next = temp.next.next;
    	}
    }
    public boolean find(int val) {
    	boolean available = false;
    	if(head.data == val) {
    		available = true;
    	}
    	Node temp = head;
    	while(temp != null ) {
    		if(temp.data == val) {
        		return true;
        	}
    		temp = temp.next;
    	}
    	
    	return available;
    }
   public int size() {
	   int size = 0;
	   if(head == null) {
		   return size;
	   }
	   Node temp = head;
	   while(temp.next!=null) {
		   temp = temp.next;
		   size++;
	   }
	   return size;
   }
   public static void main(String[] args) {
	   System.out.println("LinkedListPrimeDemo2 ");
	   LinkedListPrimeDemo2 list = new LinkedListPrimeDemo2();
	   list.add(10);
	   list.add(20);
	   list.add(30);
	   list.add(40);
	   list.add(50);
	   //System.out.println(list.size());
	   //list.remove(30);
	   System.out.println(list.find(30));
}
}
