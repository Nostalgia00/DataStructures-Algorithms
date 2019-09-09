import java.util.*;
public class decrypt{
    public static void main(String[] args){
        // long p = 29;
        // long g = 2;
        // long gxModp = 3;
        // long c1 = 23;
        // long c2 = 27;
		Scanner scan = new Scanner(System.in);
        String pubKey = scan.nextLine();
        String cipher = scan.nextLine();
		
		String array1[]= pubKey.split(" ");
		String array2[]= cipher.split(" ");
		
		//public key
        long p = Long.parseLong(array1[0]);
        long g = Long.parseLong(array1[1]);
        long gxModp = Long.parseLong(array1[2]);

        //cipher
        long c1 = Long.parseLong(array2[0]);
        long c2 = Long.parseLong(array[1]);

        long testKey=0l;
        boolean found = false;
        long x = 2l;
		

        // //public key
        // long p = 24852977l;
        // long g = 2744l;
        // long gxModp = 8414508l;

        // //cipher
        // long c1 = 15268076l;
        // long c2 = 743675l;

        // long testKey=0l;
        // boolean found = false;
        // long x = 2l;

        //brute force checks all the values between 2 and p
        while((!found)&&(x<=p)){
            testKey =  modPow(g,x,p);
            if(gxModp==testKey)
                found=true;  
            else
                x++;          
        }
        //decyphers the message
        long calc = modMult(c2,modPow(c1,(p-1-x),p),p);
        System.out.println("The secret messege is: "+calc);
    }

    //raises a number to a power with the given modulus
    //when raising a number to a power, the number quickly becomes too large to handle
    //you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
    //however  you  want  the  algorithm  to  work  quickly -having  a  multiplication loop would result in an O(n) algorithm!
    //the trick is to use recursion -keep breaking the problem down into smaller pieces and use the modMult method to join them back together
    public static long modPow(long number, long power, long modulus){
        if(power==0)return 1;
        else if (power%2==0) {
            long halfpower=modPow(number, power/2, modulus);
            return modMult(halfpower,halfpower,modulus);
        }
        else{
            long halfpower=modPow(number, power/2, modulus);
            long firstbit = modMult(halfpower,halfpower,modulus);
            return modMult(firstbit,number,modulus);
        }
    }

    //multiplies the first number by the second number with the given modulu
    //a  longcan  have  a  maximum  of  19  digits.  Therefore,  if  you're  multiplying two ten digits numbers the usual way, things will go wron
    //you need to multiply numbers in such a way that the result is consistently moduloed to keep it in the range
    //however  you  want  the  algorithm  to  work  quickly -having  an  addition  loop would result in an O(n) algorithm!
    //the trick is to use recursion -keep breaking down the multiplication into smaller pieces and mod each of the pieces individuall
    public static long modMult(long first, long second, long modulus){
        if(second==0)return 0;
        else if (second%2==0) {
            long half=modMult(first, second/2, modulus);
            return (half+half)%modulus;
        }
        else{
            long half=modMult(first, second/2, modulus);
            return (half+half+first)%modulus;
        }

    }
}