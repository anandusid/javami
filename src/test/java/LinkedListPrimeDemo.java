
class NodeA {
    int data;     // Data stored in the node
    NodeA next;    // Reference to the next node

    public NodeA(int data) {
        this.data = data;   // Initialize node data
        this.next = null;   // Initialize the next node reference to null
    }
}

public class LinkedListPrimeDemo {
    private NodeA head;  // Head of the list

    // Constructor to initialize the linked list
    public LinkedListPrimeDemo() {
        this.head = null;  // Initially, the list is empty
    }

    public void add(int val) {
    	
    	NodeA data = new NodeA(val);
    	
    	if(head == null) {
    		
    		head = data;
    	} else {
    		
    		NodeA temp = head;
    		
    		while(temp.next != null) {
    			
    			temp = temp.next;
    		}
    		
    		temp.next =  data;
    	}
    	
    	System.out.println("added item is: "+ val);
    	
    }
    
   public void remove(int val) {
    	
    	if( head == null) {
    		System.out.println("emplty list");
    	}
    	
    	if(head.data == val) {
    		head = head.next;
    		return;
    	}
    	NodeA temp = head;
    	while(temp.next != null && temp.next.data != val) {
    		temp = temp.next;	
    	}
    	if(temp.next != null) {
    		temp.next = temp.next.next;
    	}
    	
    	System.out.println("remove item is: "+ val);
    	
    }
   
   public boolean find(int val) {
	   if( head == null) {
   		return false;
   	}
   	
   	if(head.data == val) {
   		System.out.println(head.data);
   		return true;
   	}
   	NodeA temp = head;
   	
   	while(temp != null ) {
   		
   		if(temp.data == val) {
   			return true;
   		}
   		
   		temp = temp.next;
   		
   	}
   	return false;
   	
   }
   
   public int size() {
	   int size =1;
	   if(head == null) {
		   System.out.println("empty linked list ---");
	   }
	   NodeA temp = head;
	   while(temp.next != null) {
		   size++;
		   temp = temp.next;
	   }
	   return size;
   }
   
   public static void main(String[] args) {
	   LinkedListPrimeDemo list = new LinkedListPrimeDemo();
	   list.add(10);
	   list.add(20);
	   list.add(30);
	   list.add(40);
	   list.add(50);
	   //System.out.println(list.size());
	   list.remove(30);
	   System.out.println(list.size());
}
}
