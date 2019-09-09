/**This program uses Monte Carlo simulation to determine the probability that 
 * the candidates of the Irish 2018 presidential election will place in a given
 * order, based on their Paddypower odds.
 * @author Anthony Donohoe 
 * @version 23/10/2018
 */
import java.lang.Math;
public class presidentialMonteCarlo{
	public static void main(String[] args){
		
		//Candidate odds
		double MH = 50d/(50+1);
		double SG = 1d/(20+1);
		double LR = 1d/(33+1);
		double PC = 1d/(40+1);
		double JF = 1d/(100+1);
		double GD = 1d/(100+1);
		// double SG = 6d/(4+6);
		// double LR = 1d/(2+1);
		// double PC = 1d/(8+1);
		// double JF = 1d/(16+1);
		// double GD = 1d/(25+1);
		double[] odds = {MH,SG,LR,PC,JF,GD};	
		int[] results = raceResults(odds);	
		
		int[] testcase = {1,2,3,4,5,6}; //The result order to be checked
		
		int monteCarloSize = 10000000;
		int k=0;		
		int count=0; //count number of times the testcase occurs
		boolean flag=true;
		// Uses Monte Carlo simulation to determine probability
		for(int i=0;i<monteCarloSize;i++){
			results=raceResults(odds);
			flag=true;
			k=0;
			while(flag&&k<results.length){
				// if results do not match testcase flag will be set to false and loop will end
				flag=(results[k]==testcase[k]);
				k++;
			}
			if(flag){
				count++;
			}
		}
		System.out.println((double)count/monteCarloSize);
		
	}
	/**
     * Takes odds of each candidate winning, normalises the numbers and returns the
	 * normalised array.
     * @param numbers the odds of winning for each candidate
	 * @return the normalised odds of each candidate winning
     */	
	public static double[] normalise(double[] numbers){
		double sum=0;
		//determine sum of numbers
		for(int i=0;i<numbers.length;i++){
			sum+=numbers[i];
		}
		// normalised value = oldValue/sum
		for(int i=0;i<numbers.length;i++){
			numbers[i]=numbers[i]/sum;
		}
		return numbers;
	}
	/**
     * Creates an array of placements for each candidate given their odds of winning
     * @param numbers the odds of winning for each candidate
	 * @return an instance of placements for each candidate
     */	
	public static int[] raceResults(double[] numbers){
		//array to hold the initial candidate odds
		double[] tempArray = new double[numbers.length];
		for(int i=0;i<numbers.length;i++){
			tempArray[i] = numbers[i];
		}
		//initialise array of placements
		int[] race = new int[tempArray.length];		
		int position = 1;
		double check;
		double track=0;
		int j=0;
		for(int i=1;i<=tempArray.length;i++){
			tempArray=normalise(tempArray);
			j=0;
			track=0;
			check = Math.random(); //The random number between 0-1 to be checked
			while(position==i){	
				track+=tempArray[j];//By adding the probabilities we check the candidates in order of highest probability
				if(check<=track){
					race[j]=position;
					tempArray[j]=0;
					position++;
				}
				j++;
			}			
		}
		return race;
	}
	/**
     * Print out the winning odds of the candidates
     * @param numbers the odds of winning for each candidate
	 * @return void
     */	
	public static void printOdds(double[] numbers){
		for(int i=0;i<numbers.length;i++){
			System.out.println(numbers[i]);
		}
	}
	/**
     * Print out the result given an array of numbers
     * @param numbers the placement of the candidates
	 * @return void
     */	
	public static void printResults(int[] numbers){
		for(int i=0;i<numbers.length;i++){
			System.out.println(numbers[i]);
		}
	}
}