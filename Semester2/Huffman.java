import java.util.*;
import java.util.PriorityQueue;

public class Huffman{

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       
       System.out.print("Enter your sentence: ");
       String sentence = in.nextLine();
       String binaryString="";      //this stores the string of binary code
       
       
       for(int i=0; i < sentence.length(); i++){        //go through the sentence
           int decimalValue = (int)sentence.charAt(i);      //convert to decimal
           String binaryValue = Integer.toBinaryString(decimalValue);      //convert to binary
           for(int j=7;j>binaryValue.length();j--){
               binaryString+="0";           //this loop adds in those pesky leading zeroes
            }
           binaryString += binaryValue+" "; //add to the string of binary
       }
       System.out.println(binaryString);    //print out the binary
       
              
       int[] array = new int[256];      //an array to store all the frequencies
       
       for(int i=0; i < sentence.length(); i++){    //go through the sentence
           array[(int)sentence.charAt(i)]++;    //increment the appropriate frequencies
           
       }
       
       
       PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees    
        
       Tree myTrees[] = new Tree[2*array.length]; //creates an array of trees with some extra for later
       for(int i=0; i<array.length; i++){ //go through frequency array
           if(array[i]>0){ //print out non-zero frequencies - cast to a char
                System.out.println("'"+(char)i+"' appeared "+array[i]+((array[i] == 1) ? " time" : " times"));
     
               //FILL THIS IN:
               
               //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ
				myTrees[i] = new Tree();
				myTrees[i].root = new Node();
				myTrees[i].frequency = array[i];
				myTrees[i].root.letter = (char)i;
				PQ.add(myTrees[i]);
			   
               //create a new Tree 
               //set the cumulative frequency of that Tree
               //insert the letter as the root node 
               //add the Tree into the PQ
                      
            }
        }
        
        int count = array.length;
		Tree lastTree = new Tree();
		lastTree.root = new Node();
		int freqLeft=0;
		int freqRight=0;
        while(PQ.size()>1){             //while there are two or more Trees left in the forest
            
            //FILL THIS IN:
            
            //IMPLEMENT THE HUFFMAN ALGORITHM
			myTrees[count]=new Tree();
			myTrees[count].root=new Node();
			//left child
			lastTree=PQ.poll();
			System.out.println(lastTree.root.letter);
			freqLeft = lastTree.frequency;
			myTrees[count].root.leftChild=lastTree.root;
			//right child
			lastTree=PQ.poll();
			freqRight = lastTree.frequency;
			myTrees[count].root.rightChild=lastTree.root;

			myTrees[count].frequency = freqLeft+freqRight; //new frequency
			PQ.add(myTrees[count]);
			count++;
            
            //when you're making the new combined tree, don't forget to assign a default root node (or else you'll get a null pointer exception)
            //if you like, to check if everything is working so far, try printing out the letter of the roots of the two trees you're combining
        }
        
        Tree HuffmanTree = PQ.poll();   //now there's only one tree left - get its codes
        
        
        //FILL THIS IN:
        for(int i=0;i<array.length; i++){
			if(array[i]>0){
				System.out.println("'"+(char)i+"' : "+HuffmanTree.getCode((char)i));
			}
		}
		
		for(int i=0;i<sentence.length();i++){
			System.out.print(HuffmanTree.getCode(sentence.charAt(i)));
		}
        //get all the codes for the letters and print them out
        //call the getCode() method on the HuffmanTree Tree object for each letter in the sentence

        //print out all the info

    }      
}