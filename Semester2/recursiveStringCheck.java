import java.util.*;
public class recursiveStringCheck{
	public static void main (String[] args){
		String sentence = "How many unique characters in this string?";
		ArrayList<Character> seen = new ArrayList<Character>();
		System.out.println(countunique(sentence,seen));
		
	}
	public static int countunique(String sentence, ArrayList<Character> seen){
		if(sentence.length()>0){
			if(!seen.contains(sentence.charAt(0))){
				seen.add(sentence.charAt(0));
				return countunique(sentence.substring(1), seen) +1;
			}
			else
				return countunique(sentence.substring(1), seen);
		}
		else
			return 0;
    }
}