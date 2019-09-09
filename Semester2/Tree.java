import java.io.*;
import java.util.*;               // for Stack class

////////////////////////////////////////////////////////////////
public class Tree implements Comparable<Tree>
   {
   public Node root;             // first node of tree
   public int frequency=0;

// -------------------------------------------------------------
   public Tree()                  // constructor
      {   root = null; }            // no nodes in tree yet
// -------------------------------------------------------------

//the PriorityQueue needs to be able to somehow rank the objects in it
//thus, the objects in the PriorityQueue must implement an interface called Comparable
//the interface requires you to write a compareTo() method so here it is:

   public int compareTo(Tree object) { //
        Node current1 = new Node();
        Node current2 = new Node();
		char smallLetter1 ='-';
		char smallLetter2 = '-';

        if (frequency - object.frequency > 0) { // compare the cumulative frequencies of the tree
            return 1;
        } else if (frequency - object.frequency < 0) {
            return -1; // return 1 or -1 depending on whether these frequencies are bigger or smaller
        } else {
			if(smallestLetter>object.smallestLetter)
				return 1;
			else
				return -1;
        }
    }
    
// -------------------------------------------------------------

   String path="error";     //this variable will track the path to the letter we're looking for 

   public String getCode(char letter){  //we want the code for this letter
 
        //Track the path along the way and store the current path when you arrive at the right letter
        return this._getCode(letter, this.root, ""); //return the path that results
    }

    private String _getCode(char letter, Node current, String path) {
        if (current == null) {
            return null;
        }
        if (current.letter == letter) {
            return path;
        }

        String leftPath = this._getCode(letter, current.leftChild, path + "0");
        if (leftPath != null) {
            return leftPath;
        }

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }

}  // end class Tree