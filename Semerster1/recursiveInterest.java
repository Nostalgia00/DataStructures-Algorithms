import java.util.Scanner;
import java.text.DecimalFormat;
public class recursiveInterest {
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		int years = scan.nextInt();
		double I = scan.nextDouble();
		double balance = scan.nextDouble();
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println(df.format(calcInterest(balance, I, years)));
	}
	
	// returns the new balance after a number of years at I interest rate
	public static double calcInterest(double balance, double I, int years){
		
		double interest = 1+(I/100d);
		if(years==0){
			return balance;
		}
		else{
			return calcInterest(balance*interest,I,years-1);
		}
		
	}
}