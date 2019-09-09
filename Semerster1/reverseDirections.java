import java.util.Scanner;
public class reverseDirections{
	
    public static void main(String[] args){
        
        Stack theStack = new Stack(10);
        Scanner scan = new Scanner(System.in);
		
		//fills the stack with directions
        while(theStack.isEmpty()||!(theStack.peek().compareTo("Arrived")==0)){			
			theStack.push(scan.nextLine());
			if(!theStack.isEmpty()&&theStack.peek().compareTo("Go Back")==0){//if direction is Go Back the previous direction is removed
                theStack.pop();
				theStack.pop();
			}
        }
        String nextDir = "";
        
		//prints out the reveresed direction
        while (!theStack.isEmpty()){
            nextDir = theStack.pop();
            if(nextDir.compareTo("Go North")==0)
				System.out.println("Go South");            
            if(nextDir.compareTo("Go South")==0)
                System.out.println("Go North");    
            if(nextDir.compareTo("Go East")==0)
                System.out.println("Go West");    
            if(nextDir.compareTo("Go West")==0)
                System.out.println("Go East");      
        }
    }
}