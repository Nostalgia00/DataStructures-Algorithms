import java.util.Scanner;
import java.text.DecimalFormat;

public class recursiveBirthday {
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		DecimalFormat df = new DecimalFormat("####0.000");
		System.out.println(df.format(1-birthdayProb(N)));
	}
	
	// returns the probability that N a number of people, does NOT have a pair with shared birthdays
	public static double birthdayProb(int N){
		
		if(N==1){
			return 1;
		}
		else{
			return ((365-(N-1))/365d)*birthdayProb(N-1);
		}
		
	}
}