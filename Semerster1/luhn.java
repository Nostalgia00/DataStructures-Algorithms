/**
 * luhn's Algorithm tester
 * @author Anthony Donohe
 * @author 68462364
 * @version 02-10-2018
 */
import java.util.Scanner;
public class luhn{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		//String TestNumber = sc.nextLine();
		String TestNumber = "4539682995824395";
		System.out.println(luhnCheck(TestNumber));
		// if(luhnCheck(TestNumber))
			// System.out.println("VALID");
		// else
			// System.out.println("INVALID");
	}
	/**
	 * This is a method that takes in a credit card number and checkes its validity by
	 * Luhn's algorithm
	 * <p>usage: luhnCheck(cardString) </p>
	 * @param String the credit card number
	 * @return Returns true if the card is valid and false if it is invalid
	 */
	public static boolean luhnCheck(String Card){
		
		int num1=0;
		int num2=0;
		int temp=0;
		
		//Sum of every second digit from the last
		for(int i =Card.length()-1;i>=0;i-=2){
			num1 += Integer.parseInt(Card.substring(i, i+1));
			System.out.println(Integer.parseInt(Card.substring(i, i+1)));			
		}
		
		//Sum of every second digit doubled, 9 is subtracted if >9
		for(int i =Card.length()-2;i>=0;i-=2){
			temp = 2*Integer.parseInt(Card.substring(i, i+1));
			if(temp>9)
				temp-=9;
			num2+=temp;
		}
		
		//Sum of both numbers
		int result = num1+num2;
		
		//If the result modded by 10 is 0 the card is valid
		return (result%10==0);
	}
}