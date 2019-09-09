/**
 * @author Anthony Donohoe 
 * @version 08/10/2018
 */
 import java.lang.Math;
public class collatz_v2{
	
	public static void main(String[] args){
		
		long stuNum = 68462364;
		long collatzNum = bestCollatzRun(stuNum);
		System.out.println(collatzNum);		
		System.out.println(longestCollatzSequence(collatzNum));	
	}
	/**
     * Using the Collatz conjecture this method counts the number of steps in a sequence begining at an inputted number
     * @param num the number to be checked
	 * @return number of steps in the sequence
     */
	public static int collatzCount(long num){		
		int count=0;
		while(num !=1){
			if(num%2==0)
				num = num/2;
			else
				num = (num*3)+1;
			count++;
		}
		return count;
	}
	/**
     * Replaces a digit in a given number at a given index with a given value
     * @param num the number which will have a digit changed
	 * @param value the number which will replace the digit
	 * @param index the index of the digit to be repaced
	 * @return the number with its digit replaced.
     */
	public static long changeDigit(long num, int value, int index){
		index++;
		long multNum= (long)(Math.pow(10,index));
		long temp = num/multNum;
		num=(temp*multNum)+(num%(multNum/10))+(value*(multNum/10));
		return num;
	}
	/**
     * Loops through every iteration of a given number, replacing one digit with 0-9 and checks the lenght of its Collatz sequence. The number with the longest sequence will be returned.
     * @param num the number which will have a digit changed and tested
	 * @return the number with the longest collatz sequence.
     */
	public static long bestCollatzRun(long num){
		long collNum=0;
		int longestRun =0;
		int currentRun=0;
		long bestCollNum=0;
		for(int i=0;i<=7;i++){
			for(int j=0;j<=9;j++){
				collNum=changeDigit(num,j,i);
				currentRun=collatzCount(collNum);
				if(currentRun>longestRun){
					longestRun=currentRun;
					bestCollNum=collNum;					
				}
			}
		}
		return bestCollNum;		
	}
	public static long longestCollatzSequence(long num){
		
		long longestSeqNum=0;
		
		while(num<=(Long.MAXVALUE-100){
			
			//if(((num-1)/3)%2==0){}
		}
		
		return longestSeqNum;
		
	}
}