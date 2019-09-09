/**The purpose of this program is to read in a Number N and output the distance between 
 * the prime number that preceeds it, and the prime that follows it. If the number itself
 * happens to be prime, then the program outputs the distance to the subsequent prime.
 * @author Anthony Donohoe 
 * @version 16/10/2018
 */
 import java.util.*;
public class searchPrimes{
	public static void main (String[] args){
		
		Scanner scan = new Scanner(System.in);
		int N =scan.nextInt();
		int lowPrime=0;
		int highPrime=0;
		int count = 0;
		
		boolean[] numArray = new boolean[1000+1];
		
		//fill array with true
		for(int i=2;i<numArray.length;i++){
			numArray[i]=true;
		}
		
		//all non-primes set to false
		for(int i=2;i<numArray.length;i++){
			if(numArray[i]){
				for(int j=2;(i*j)<numArray.length;j++){
					numArray[i*j]=false;
				}
			}
		}
		//printArray(numArray); //Print array
		
		//search array
		if(numArray[N]){
			lowPrime = N;
		}
		else{
			//find lower prime
			count = N;
			while(lowPrime==0){
				if(numArray[count]){
					lowPrime = count;
				}
				else{
					count--;
				}
			}
		}
		//find higher prime
		count = N+1;
		while(highPrime==0){
			if(numArray[count]){
				highPrime= count;
			}
			else{
				count++;
			}
		}
		if(lowPrime == 0 || highPrime ==0)
		{
			System.out.println("Primes not found");
		}
		else{
			System.out.println(highPrime-lowPrime);
		}
	}
		
	
	/**
	 * This method prints out the array and indcates primes
	 * <p>usage: printArray(numArray) </p>
	 * @param numArray a boolean array with prime indices set to true
	 */
	public static void printArray(boolean[] numArray){
		
		for(int i=0;i<numArray.length;i++){
			if(numArray[i]){
				System.out.println(i+" is a prime");
			}
			else{
				System.out.println(i+" is not a prime");
			}
		}
	}
}