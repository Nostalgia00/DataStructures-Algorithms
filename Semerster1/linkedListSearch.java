import java.lang.Math;
public class linkedListSearch{
	
	public static void main (String[] args){
		
		LinkedList myList = new LinkedList();	
		for(int i=0;i<10;i++){
			myList.insertHead((int)(Math.random()*100));
		}		
		myList.display();
		System.out.println("\n\n"+myList.smallest());
		System.out.println("\n\n"+myList.largest());
		
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		int temp;
		while(!myList.isEmpty()){
			temp=myList.deleteHead().data;
			if(temp<smallest){
				smallest = temp;
			}
			if(temp>largest){
				largest = temp;
			}
		}
		System.out.println("\n\n"+smallest);
		System.out.println("\n\n"+largest);
	}
}
class LinkedList {
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
class Link{
	public int data;
	public Link next;
	public Link previous;
	public Link(int datain){
		data = datain;    
	}
	public void displayLink(){
		System.out.println(data);
	}
}
