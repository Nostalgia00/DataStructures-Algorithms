import java.util.*;
public class asciiCount{
	public static void main (String[] args){
		
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine(); //read in sentence
		int tempInt;
		String ASCIIString = "";
		String tempString = "";
		int[] ASCIIarray = new int[256]; //array for counts
		char tempChar;
		
		//loop through sentence characters
		for(int i=0;i<sentence.length();i++){
			tempInt = (int)sentence.charAt(i); //convert char to int
			ASCIIarray[tempInt]++; //iterate count
			tempString = Integer.toBinaryString(tempInt);
			while(tempString.length()<7){ //ensures leading zeros are included
				tempString = "0"+tempString;
			}
			ASCIIString = ASCIIString+tempString+" "; //build ACSII sentence	
		}
		System.out.println(ASCIIString+"\n");
		
		for(int i=0;i<ASCIIarray.length;i++){
			if(ASCIIarray[i]!=0){
				tempChar = (char)i; //integer to char
				if(ASCIIarray[i]==1)
					System.out.println("'"+tempChar+"'"+" appeared "+ASCIIarray[i]+" time.");
				else
					System.out.println("'"+tempChar+"'"+" appeared "+ASCIIarray[i]+" times.");

			}
		}
	}
}