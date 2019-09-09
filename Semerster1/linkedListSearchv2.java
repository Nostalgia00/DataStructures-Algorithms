import java.lang.Math;
public class linkedListSearchv2{
	
	public static void main (String[] args){
		
		LinkedList myList = new LinkedList();	
		for(int i=0;i<10;i++){
			Link newLink = new Link((int)(Math.random()*100));
			myList.insertHead(newLink);
		}	
		display(myList);
		System.out.println("\n\n"+search(myList));
	}
	
	public static int search(LinkedList myList){
		
		Link current = myList.first;
		int[] myArray = new int[100]; // Array for saving list members
		int largest=Integer.MIN_VALUE;
		int i=0;
		Boolean flag=false;
		while(current!=null){ //loop until we reach the end of the links
			// if the pointers do not agree return 0
			if(current.next!=null&&!(current.next.previous.data==current.data)){
				return 0;
			}
			// if the linked list loops return 0
			if(checkArray(myArray, current.data)){
				return 0;
			}
			myArray[i]=current.data; //save list memebers to an array
			i++; 
			
			// returns a true flag if we successfully reach the end of the list
			if(current==myList.last){
				flag=true;
			}
			// saves the largest value
			if(current.data>largest){
				largest=current.data;
			}		
			// moves on to the next member of the list			
			current=current.next;			
		}
		if(flag){ //Will only allow the program to return largest if we successfully reached the end of the list
			return largest;
		}
		else{
			return 0;
		}	
	}
	// Checks the array to see if the given integer is present and returns a boolean
	public static boolean checkArray(int[] myArray, int data){
		for(int i=0;i<myArray.length;i++){
			if(myArray[i]==data){
				return true;
			}
		}
		return false;
	}
	public static void display(LinkedList myList){
		Link current = myList.first; 
		// start with first link
		while(current!=null){
			System.out.println(current.data);
			//print out the link
			current=current.next; 
			//keep going until you come to the end
		}
	}
	
}
class Link{
	public int data;
	public Link next;
	public Link previous;
    
    public Link(int input){
        data=input;
        next=null;
        previous=null;
    }
}

class LinkedList {
	public Link first;
    public Link last;

	public LinkedList( ){
		first=null;
        last=null;
	}

	public boolean isEmpty( ){
		return (first==null);
	}
    
    public void insertHead(Link insert){
        if(isEmpty()){
            first=insert;
            last=insert;
        }else{
            first.previous=insert;
            insert.next=first;
            first=insert;
        }
    }
}