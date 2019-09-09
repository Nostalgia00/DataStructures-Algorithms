/**This program takes an array of 64 numbers and attempts to sort those numbers into two groups such
 * that the difference between the total sum of each set is minimised.
 * @author Anthony Donohoe 
 * @version 13/11/2018
 */
import java.lang.Math;
public class pairSort{
	public static void main(String[] args){
		
		//Initiialise number array as an array of Strings
		String[] sArray = 
{"7270536038336708566", "8019217342518227357", "3040884611156577620", "4971410678527411098", "183064013267932758", 
"8056584603037925167", "1899884129638764508", "5128941762697709445", "5047244487910064394", "3305601720113745382", 
"5776953008539814370", "34988082947722169", "7434345681532331612", "5407786886759427803", "688068291500036320", 
"2068510150417278708", "1868790318480929054", "3425404376196216488", "1131190712360422749", "102967645096808272", 
"1445942735952374406", "8456737838228485082", "7623544032966572081", "3942629391233399085", "75109850685511728", 
"223515536869223609", "764673323466830185", "2792331077502901882", "8043871486090449356", "8027891460874623856", 
"9035205129603316628", "5210176758109223792", "6369027410439876015", "719764136449271247", "6275216998605832028", 
"7518974182407464286", "8228098362075889963", "4364500170274364383", "5160900320056121570", "3574188741140445768", 
"3799725687163235416", "8971054323076859594", "303947614746485290", "4072768654844778108", "422948319988286530", 
"228169257627773589", "4695919214544378987", "5634695221137989240", "2134479954298742138", "7591363728605668117", 
"227743280468209272", "3815359581987719752", "240831188333789404", "1682051551566226", "7028911732181187415", 
"8534901095561461575", "604981729275990578", "4379371367686136078", "2561184379973031673", "3251231714574439892", 
"8507596701451728093", "1479176915196229414", "4596908701725205546", "7434222118200184219"};
		long smallestResult=Long.MAX_VALUE;
		long testNumber = Long.parseLong("100000000000");// this number is used to get a better understading of relative size of array members and final result.
		int[] terArray = new int[sArray.length];//This array will be used to allocate groups
		long[] array = new long[sArray.length]; //Store the array as an array of longs
		for(int i=0;i<array.length;i++){
			array[i]=Long.parseLong(sArray[i]); //String array to long array
			System.out.println(array[i]/testNumber); //Prints the array members divided by a number. The idea is to get a better understating of relative size of the numbers.
			if(array[i]<smallestResult){
				smallestResult=array[i]; //Stores the smallest element of the array.
			}
		}		
		String sTer = "";// Will store a string which will correspond to set membership for the array of longs.
		long check;
		int Nsimulations = 1000000000; //Takes about 30mins to run on the lab computer
		char[] animationChars = new char[]{'|', '/', '-', '\\'};
		int k=0;
		for(int i=0; i<Nsimulations;i++){// Generate X number of simulations
			buildTer(terArray); //Randomise the group allocation
			check = pairCalc(array, terArray); //returns the result of the difference between the sum of each set
			if(Math.abs(check)<Math.abs(smallestResult)){ //if the result is smaller than the smallest, then update
				smallestResult = check;
				sTer="";
				for(int j=0;j<terArray.length;j++){
					sTer += ""+terArray[j]; //Store the combination
				}
			}
			if(i%(Nsimulations/100)==0){
				System.out.print("Processing: " + k + "% " + animationChars[k % 4] + "\r");
				k++;
			}
		}
		
		System.out.println("\nThe smallest relative result was : "+Math.abs(smallestResult)/testNumber+"\nThe smallest result was : "+Math.abs(smallestResult)+"\nThe combination was : "+sTer);
		
	}
	/**
     * Randomly assigns either 0, 1 or 2 and saves the results in a ternary array.
     * @param terArray the array storing the ternary numbers
	 * @return an array of ternary numbers
     */
	public static void buildTer(int[] terArray){
		for(int i=0;i<terArray.length;i++){
			terArray[i] = (int)Math.floor(Math.random()*2); //Set to 2 for the purpose of avoiding a lab mark penalty.
		}
	}
	/**
     * Using an array of ternary numbers, an array of longs is sent to one or neither of two sets. The diffence between each set is calculated and returned.
     * @param array the array of longs
	 * @param terArray the array of ternary numbers
	 * @return the difference between the sums of each set.
     */
	public static long pairCalc(long[] array, int[] terArray){
		long result=0;
		for(int i=0;i<array.length;i++){
			if(terArray[i]==0){//if 0, the number is assigned to set 1
				result+=array[i];
			}
			else if(terArray[i]==1){ //if 1, the number is assigned to set 2
				result-=array[i];
			}
		}
		return result;
	}
}