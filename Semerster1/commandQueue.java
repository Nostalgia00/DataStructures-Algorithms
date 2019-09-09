import java.util.Scanner;
public class commandQueue{
	
	public static void main(String[] args){
		
		Queue theQueue = new Queue(10);
		Scanner scan = new Scanner(System.in);
		
		// Fills the queue with the strings read from the user followiing the commands.
		String temp ="";
		do{
			temp=scan.nextLine();
			if(temp.contains("INSERT")){
				theQueue.insert(temp.substring(7));
			}
			if(temp.contains("REMOVE")){
				theQueue.remove();
			}
		}while(scan.hasNextLine());
		
		// Removes queue elements and prints out the middle, if there is a neven number it prints out the closest to the top
		int size = theQueue.size();
		if(size%2==0){
			for(int i=1;i<=(size/2)-1;i++){ //removes untill middle
				theQueue.remove();
			}
			System.out.println(theQueue.remove()); //prints middle
		}
		else{
			for(int i=1;i<=((size-1)/2);i++){ //removes untill middle
				theQueue.remove();
			}
			System.out.println(theQueue.remove()); //prints middle
		}
	}
}