
public class StackPrimeDemo {
	
	private NodeForStack currentNode;
	
	StackPrimeDemo(){
		this.currentNode = null;
	}
	
	public void push(int val) {
		
		NodeForStack node = new NodeForStack(val);
		node.lastNode = currentNode;
		currentNode = node;
		
	}
	public int pop() {
		int val = currentNode.value;
		currentNode = currentNode.lastNode;
		return val;
	}
	
	public int peep() {
		return currentNode.value;
	}
}


class NodeForStack{
	NodeForStack lastNode;
	int value;
	NodeForStack(int val){
		this.value = val;
		this.lastNode = null;
	}
}