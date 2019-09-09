import java.lang.Math;
import java.lang.Object;
import java.time.LocalDateTime;
public class diceRoll{
	
	public static void main(String[] args){
		boolean flag =blockMined();
		System.out.println(prob6());
	}
	public static int roll(){
		return (int)((Math.random()*6)+1);
	}
	
	public static double prob6(){
		int count =0;
		double coin = 0d;
		double N = 100000000d;
		int k=0;
		char[] animationChars = new char[]{'|', '/', '-', '\\'};
		for(int i=0;i<N;i++){
			if(blockMined()){
				coin++;			
				if(roll()==6){				
					count++;
				}
			}
			if(i%(N/1000)==0){
				System.out.print("Processing: " + k/10+"."+k%10 + "% " + animationChars[k % 4] + "\r");
				k++;
			}
		}
		System.out.println("\n"+coin);
		return (double)((count/coin));
	}
	public static boolean blockMined(){
		LocalDateTime a = LocalDateTime.now();
		if(a.getNano()>=0 && a.getNano()<=100000000){
			return true	;
		}
		return false;
		
	}
}