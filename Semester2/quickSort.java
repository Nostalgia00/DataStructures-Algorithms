public class quickSort{
	public static void main(String[] args){
		String[] theArray = new String[]{"abc", "a", "baa", "dog","zodiac", "mop","sad"};
		//lists out words
		for(int i=0;i<theArray.length;i++){
			System.out.print(theArray[i]+", ");
		}
		System.out.println("\n");
		recQuickSort(0,theArray.length-1, theArray);
		//lists out sorted words
		for(int i=0;i<theArray.length;i++){
			System.out.print(theArray[i]+", ");
		}		
	}

	public static void recQuickSort(int left, int right, String[] theArray){
		if(right-left <= 0)              // if size <= 1,
			return;                      //    already sorted
		else{                            // size is 2 or larger
			String pivot = theArray[right];      // rightmost item
			// partition range
			int partition = partitionIt(left, right, pivot, theArray);
			recQuickSort(left, partition-1, theArray);   // sort left side
			recQuickSort(partition+1, right, theArray);  // sort right side
		}
	}
	
	public static int partitionIt(int left, int right, String pivot, String[] theArray){
		int leftPtr= left-1;           // left    (after ++)
		int rightPtr= right;           // right-1 (after --)
		while(true){                            
			while(check(theArray[++leftPtr],pivot)){}    // scan to the right
			while(rightPtr> 0 && check( pivot, theArray[--rightPtr])){} // scan to the left
			if(leftPtr>= rightPtr)      // if pointers cross,
				break;                    //    partition done
			else                         // not crossed, so
				swap(leftPtr, rightPtr, theArray);  //    swap elements
		}
		swap(leftPtr, right, theArray);           // swap pivot into correct place
		return leftPtr;                 // return pivot location
	}
	
	// Takes two strings and returns true if the first string contains a character which is greater than the greatest character in the second
	// if both words contain equal greatest characters, the program returns true if the first word comes before the second word in the dictonary
	public static boolean check(String first, String second){
	if(greatestChar(first)<greatestChar(second))
		return true;
	else if(greatestChar(first)==greatestChar(second)){
		if(first.compareTo(second)<0)
			return true;		
		else
			return false;
	}
	else 
		return false;
	}
	
	//returns the greater of two chars, a>b ,b>c etc.
	public static char greatestChar(String word){
		char greatest = Character.MIN_VALUE;
		for(int i=0;i<word.length();i++){
			if((int)word.charAt(i)>(int)greatest)
				greatest=word.charAt(i);
		}
		return greatest;
	}
	
	//swaps the position of two elements in an array
	public static void swap(int first, int second, String[] theArray){
		String temp = theArray[first];
		theArray[first]=theArray[second];
		theArray[second]=temp;
	}
}
