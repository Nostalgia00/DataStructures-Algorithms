public class LinkedList {
	private Link first;
	private Link last;
	public LinkedList( ){
		first=null;
	}
	public boolean isEmpty( ){
		return (first==null);
	}
	public void insertHead(int data) {   // insert at head
		Link newLink = new Link(data);   // make new link
		if( isEmpty() ){                // if empty list,
			last = newLink;              // newLink <-- last
		}else{
			first.previous = newLink;    // newLink <-- old first
		}
		newLink.next = first;           // newLink --> old first
		first = newLink;                // first --> newLink
	}
	public Link deleteHead() {
		Link temp =first;
		first = first.next;
		return temp;
	}
	public void display(){
		Link current = first; 
		// start with first link
		while(current!=null){
			current.displayLink();  
			//print out the link
			current=current.next; 
			//keep going until you come to the end
		}
	}	
	public int smallest(){
		Link current = first; 
		int smallest=Integer.MAX_VALUE;
		while(current!=null){
			if(current.data<smallest){
				smallest=current.data;
			}
			current=current.next; 
		}
		return smallest;
	}
	public int largest(){
		Link current = first; 
		int largest=Integer.MIN_VALUE;
		while(current!=null){
			if(current.data>largest){
				largest=current.data;
			}
			current=current.next; 
		}
		return largest;
	}
}