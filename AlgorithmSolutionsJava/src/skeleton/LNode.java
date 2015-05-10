package skeleton;

public class LNode {
	private int element;
	private LNode next;

	public LNode(){
		
	}
	public LNode(int value){
		this.element = value;
		this.next = null;
	}
	
	public void setLNodeElement(int value){
		this.element = value;
	}
	public int getLNodeElement(){
		return this.element;
	}
	
	public void setNextLNode( LNode nextNode){
		this.next = nextNode;
	}
	public LNode getNextLNode(){
		return this.next;
	}
}

