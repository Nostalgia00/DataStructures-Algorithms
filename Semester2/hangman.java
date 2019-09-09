//68462364
//18146058
import java.util.*;
import java.lang.Math.*;
public class hangman{

    public static void main(String args[]){
        
        FileIO reader = new FileIO();
        Scanner scan = new Scanner(System.in);
 
        String[] inputs = reader.load("X://CS211//dictionary.txt");    //Reading the File as a String array
        
		//grab a random word
		int randNum = (int)(Math.random()*inputs.length);
        String word = inputs[randNum];
		//System.out.println(word);
		char[] guessSpace = new char[word.length()];
		ArrayList<Character> seen = new ArrayList<Character>();
		String[] hangMan=new String[23];
		// base case hang man
		hangMan[0]= " ____________________";
		hangMan[1]= "| .__________________|";
		hangMan[2]= "| | / /";
		hangMan[3]= "| |/ /";
		hangMan[4]= "| | / ";
		hangMan[5]= "| |/";
		hangMan[6]= "| |";
		hangMan[7]= "| |";
		hangMan[8]= "| |";
		hangMan[9]= "| |";
		hangMan[10]="| |";
		hangMan[11]="| |";
		hangMan[12]="| |";
		hangMan[13]="| |";
		hangMan[14]="| |";
		hangMan[15]="| |";
		hangMan[16]="| |";
		hangMan[17]="| |";
		hangMan[18]="\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|";
		hangMan[19]="|\"|\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|\"|";
		hangMan[20]="| |                   | |";
		hangMan[21]=": :                   : :  sk";
		hangMan[22]=". .                   . .";
		
			
		//build up placeholder spaces
		for(int i=0; i<word.length()-1;i++){
				guessSpace[i] ='_';
		}
		int misses=0;
		int correct=0;
		//will exit loop if too many misses or all letters are guessed
		while(misses<=6&&!(correct==word.length()-1)){
			
			//print out hangman
			for(int i=0;i<hangMan.length;i++){
				System.out.println("\t"+hangMan[i]);
			}	
		
			System.out.print("\n\n\t");
			for(int i=0;i<word.length()-1;i++){
				System.out.print(guessSpace[i]+" ");
			}
			System.out.println();
			char checkChar = scan.next().charAt(0);
			
			//checks for already guessed letters
			if(!seen.contains(checkChar)){
				boolean check=false;
				int lastCorrect=correct;
				for(int i=0;i<word.length();i++){
					if(word.charAt(i)==checkChar){
						guessSpace[i]=word.charAt(i);
						correct++;
						seen.add(checkChar);
					}
					//build hangman
					if(i==word.length()-1&&lastCorrect==correct){
						misses++;
						if(misses==1){
							hangMan[0]=" ___________.._______";
							hangMan[1]="| .__________))______|";
							hangMan[2]="| | / /      ||";
							hangMan[3]="| |/ /       ||";
							hangMan[4]="| | /        ||";
							hangMan[5]="| |/         ||";
							hangMan[6]="| |          ||";
							hangMan[7]="| |          ||";
						}
						if(misses==2){							
							hangMan[4]= "| | /        ||.-''.";
							hangMan[5]= "| |/         |/  _  \\";
							hangMan[6]= "| |          ||  `/,|";
							hangMan[7]= "| |          (\\`_.'";							
						}
						if(misses==3){
							
							hangMan[8]= "| |         .-`--'.";
							hangMan[9]= "| |          |. .|   ";
							hangMan[10]="| |          |   |   ";
							hangMan[11]="| |          | . |    ";
							hangMan[12]="| |          |   |     ";
							
						}
						if(misses==4){
							hangMan[8]= "| |         .-`--'.";
							hangMan[9]= "| |          |. . Y\\";
							hangMan[10]="| |          |   | \\";
							hangMan[11]="| |          | . |  \\";
							hangMan[12]="| |          |   |   (`";
							
						}
						if(misses==5){
							hangMan[8]= "| |         .-`--'.";
							hangMan[9]= "| |        /Y . . Y\\";
							hangMan[10]="| |       // |   | \\";
							hangMan[11]="| |      //  | . |  \\";
							hangMan[12]="| |     ')   |   |   (`";
							
						}
						if(misses==6){
							hangMan[13]="| |            '||";
							hangMan[14]="| |             ||";
							hangMan[15]="| |             ||";
							hangMan[16]="| |             ||";
							hangMan[17]="| |             | \\";
							
						}
											
					}
								
				}
			}
			else
				System.out.println("Already entered!");
		}
		if(misses<=6){
			System.out.print("\t");
			for(int i=0;i<word.length()-1;i++){
				System.out.print(guessSpace[i]+" ");
			}
			System.out.println();
			System.out.println("\tCongradulations!");
		}
		else{	
			hangMan[13]="| |          ||'||";
			hangMan[14]="| |          || ||";
			hangMan[15]="| |          || ||";
			hangMan[16]="| |          || ||";
			hangMan[17]="| |         / | | \\";
			hangMan[18]="\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|";
			hangMan[19]="|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|";
			hangMan[20]="| |        \\ \\        | |";
			hangMan[21]=": :         \\ \\       : :  sk";
			hangMan[22]=". .          `'       . .";
			for(int i=0;i<hangMan.length;i++){
				System.out.println("\t"+hangMan[i]);
			}	
			System.out.println("\tGame over!");
		}
        
    }
}
