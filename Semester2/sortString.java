public class sortStrings{
	public static void main(String[] args){
		String[] theArray = new String[]{"abb", "aa", "baa", "dog","grandad", "there","goodnight"};
		for(int i=0;i<theArray.length;i++){
			System.out.print(theArray[i]+", ");
		}
		System.out.println("\n");
		recQuickSort(0,6);
		for(int i=0;i<theArray.length;i++){
			System.out.print(theArray[i]+", ");
		}
		
	}
}