public class recursive8Count{
	public static void main (String[] args){
		System.out.println(count8s(8832858822l));
	}
	public static int count8s(long input){		
		if(input%10>0){
			if(input%100==88)
				return count8s(input/10)+2;
			if(input%10==8)
				return(count8s(input/10)+1);
			else
				return(count8s(input/10));
		}
		else{
			return 0;
		}        
    }
}