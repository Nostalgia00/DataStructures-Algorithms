/**
 * This program reads in a list of numbers and returns the median number.
 * @author Anthony Donohoe 
 * @version 06/11/2018
 */
import java.util.*;
public class bubbleSort{	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		double median;
		
		//Declare and initialise array
		int[] array=new int[N];
		for(int i=0;i<N;i++){
			array[i] = scan.nextInt();
		}
		
		//Bubblesort
		for(int j =N;j>0;j--){
			for(int i=1;i<j;i++){
				if(array[i-1]>array[i]){
					swap(i-1,i,array);
				}
			}
		}
		
		// test whether or not the array is of even length
		if(N%2==0){
			median = (double)(array[N/2]+array[(N/2)-1])/2;
		}
		else
		{
			median = (double)array[(N)/2];
		}
		System.out.println(median);
	}
	/**
     * This method swaps the numbers at the indexes first and second in a given array 
     * @param first the index of the first number to be swapped
	 * @param second the index of the second numbe to be swapped with the first.
     */
	public static void swap(int first, int second, int[] array){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	/**
     * Prints the contents of an array to the screen.
     * @param array the array to be printed
     */
	public static void printArray(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}