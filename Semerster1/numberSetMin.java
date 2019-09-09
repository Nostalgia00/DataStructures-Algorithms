/**
 * This is a program for breaking the numbers below into two sets such that the difference between the sum total of the two sets is minimized.
 * 
 * @author Anthony Donohoe 
 * @version 06/10/2018
 */
import java.math.BigInteger;
public class numberSetMin{
	public static void main(String[] args){
		
		//Initialise an array of String which contain the numbers
		String[] Snums = {"5401592977081731", "6440476505532831", "15042041519988625", "20467528679925681", "22076843868676337", "26895787675448464", "34976635294853553", "36375014753131722", "69962528271893430", "80951893188532592", "82260848127777742", "114440145713753379", "133536973593247567", "134100801829071445", "193103273662662169", "228810939681073440", "333332867054942263", "347687508679605568", "400989167661537378", "434560043456917634", "437848327398756395", "448949407166528029", "455933993899985169", "484345467353981917", "516698581214914247", "521344233342096197", "531314426625562618", "543408397679436196", "584204774057591138", "620369647153593257", "647988088417515606", "662144009167515470", "702323294922726167", "771858641299003012", "776329537350744112", "803745179519786558", "840516798136693069", "936078491439999559", "938945607710839093", "960688503401057717"};
		//Numbers are too large for long must use BigInteger
		BigInteger[] nums = new BigInteger[Snums.length];
		BigInteger Sum = BigInteger.valueOf(0); //For tracking the total sum of the numbers
		Boolean[] indexTrack = new Boolean[Snums.length]; // An array of Booleans for keeping track of the index of the positive and negative numbers
		//For counting the set members
		int posCount = 0;
		int negCount = 1;
		
		nums[Snums.length-1] =new BigInteger(Snums[Snums.length-1]);
		indexTrack[Snums.length-1]=false;
		Sum = nums[Snums.length-1].negate();
		for(int i=Snums.length-2;i>=0;i--){
			nums[i] =new BigInteger(Snums[i]); // fills the BigInteger array with the numbers converted from strings	
			//Checks wherer the sum is brough closer to zero by adding or subtracting the number
			if((Sum.add(nums[i]).abs()).compareTo(Sum.add(nums[i].negate()).abs())==-1){
				indexTrack[i]=true;
				Sum = Sum.add(nums[i]);
				posCount++;
			}
			else{
				indexTrack[i]=false;
				Sum = Sum.add(nums[i].negate());
				negCount++;
			}
			//System.out.println(indexTrack[i]);
			//System.out.println(Sum.abs());
		}
		//For filling two arrays with the two sets
		BigInteger[] posNums = new BigInteger[posCount];
		BigInteger[] negNums = new BigInteger[negCount];
		int j=0;
		int k=0;
		for(int i=0;i<nums.length;i++){
			if(indexTrack[i]){
				posNums[j]=nums[i];
				j++;
			}
			else{
				negNums[k]=nums[i];
				k++;
			}
		}
		System.out.println("\nThe first set:\n");
		//Printing the two sets
		for(int i=0;i<posNums.length;i++){
			System.out.println(posNums[i]);
		}
		System.out.println("\n*************************\nThe second set:\n");
		for(int i=0;i<negNums.length;i++){
			System.out.println(negNums[i]);
		}
		
		System.out.println("\n*************************\nThe result of set1-set2:\n"+Sum+"\n\n");
		
		for(int i =0;i<nums.length;i++){
			System.out.println(nums[i]+"\t"+indexTrack[i]);
		}
	}
}