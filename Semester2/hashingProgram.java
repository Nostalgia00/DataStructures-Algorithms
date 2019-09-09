import java.util.*;

public class hashingProgram{
    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);
        int items = myscanner.nextInt();
        myscanner.nextLine();
        String[] contents = new String[items];
        for (int i=0; i<items;i++){
            contents[i]=myscanner.nextLine();
        }
        int size=99991;
        Solution mysolution = new Solution();
        String[] hashtable=mysolution.fill(size, contents);
        HashTable mytable = new HashTable(hashtable);

        Solution mysolution2= new Solution(); //prvents cheating by using memory
        for(int i=0;i<items;i++){
            int rand = (int)(Math.random()*items);
            String temp =contents[i];
            contents[i]=contents[rand];
            contents[rand]=temp;
        }
        int total=0;
        for(int i=0;i<items;i++){
            int slot = mysolution2.find(size, mytable, contents[i]);
            if(!hashtable[slot].equals(contents[i])){
                System.out.println("error!");
            }
        }
        System.out.println(mytable.gettotal());
    }
}

class HashTable{
    private String[] hashTable;
    private int total=0;

    public HashTable(String[] input){
        hashTable = input;
    }
    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check))
            return true;
        else{
            total++;
            return false;
        }
    }
    public int gettotal(){
        return total;
    }
}

class Solution{

    public int find(int size, HashTable mytable, String word){

        //fill this in so as to minimise collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is
        

        //multiplies each letter by 27^(index) and ads them together. Then modulos the result by size
        double hashNum=0;
        for(int j=0;j<word.length();j++){
            hashNum+=(double)(word.charAt(j))*Math.pow(27,j);
        }
		int jumpSize = 81647-((int)hashNum%81647);  
        hashNum=hashNum%size;
		while(!mytable.check((int)hashNum,word)){
			hashNum=hashNum+jumpSize;
		}
        return (int)hashNum;
    }

    public String[] fill(int size, String[] array){

        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashable array
        String[] hashtable = new String[size];
        for(int i=0;i<array.length;i++){

            //multiplies each letter by 27^(index) and ads them together. Then modulos the result by size
            double hashNum=0;
            for(int j=0;j<array[i].length();j++){
                hashNum+=(double)(array[i].charAt(j))*Math.pow(27,j);
            }
			int jumpSize = 81647-((int)hashNum%81647);  
            hashNum=hashNum%size;
			
			while(hashtable[(int)hashNum]!=null){
				hashNum=hashNum+jumpSize;
			}
            hashtable[(int)hashNum]=array[i];

            //will probably have to double hash to prevent collisions
        }
        return hashtable;
    }
    
}