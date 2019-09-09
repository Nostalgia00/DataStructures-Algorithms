import java.lang.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.io.PrintWriter;
import java.io.File;
public class vertcoinPrivateKeyGenerator{
	public static void main (String[] args){
		String hexString = "";
		char newChar;
		int randNum;
		String singleHash="";
		String doubleHash="";
		//generate 64 bit hex number
		for(int i=0;i<64;i++){
			randNum = (int)(Math.random()*16);
			switch (randNum) {				
				case 0:  newChar = '0';
						 break;
				case 1:  newChar = '1';
						 break;
				case 2:  newChar = '2';
						 break;
				case 3:  newChar = '3';
						 break;
				case 4:  newChar = '4';
						 break;
				case 5:  newChar = '5';
						 break;
				case 6:  newChar = '6';
						 break;
				case 7:  newChar = '7';
						 break;
				case 8:  newChar = '8';
						 break;
				case 9:  newChar = '9';
						 break;
				case 10: newChar = 'A';
						 break;
				case 11: newChar = 'B';
						 break;
				case 12: newChar = 'C';
						 break;
				case 13: newChar = 'D';
						 break;
				case 14: newChar = 'E';
						 break;
				case 15: newChar = 'F';
						 break;					 
				default: newChar= ' ';
						 break;
			}
			hexString = hexString+newChar;
		}
		
		//add 80 to the start
		hexString ="80"+hexString;
		//System.out.println(hexString);
		//first hash
		try{
			singleHash=sha256(hexString);
		}catch (NoSuchAlgorithmException e){}
		//System.out.println(singleHash);
		//second hash
		try{
			doubleHash=sha256(singleHash);
		}catch (NoSuchAlgorithmException e){}
		//System.out.println(doubleHash);
		//add first 8 digits to end of number
		//System.out.println(doubleHash.substring(0,8));
		
		hexString=hexString+doubleHash.substring(0,8);
		//System.out.println(hexString);
		
		BigInteger bignumber = new BigInteger(1,hexStringToByteArray(hexString));
		//System.out.println(bignumber);
		String privateKey = toBase58(bignumber);
		System.out.println(privateKey);
		
		// File file = new File("X:/CS211/privateKey.txt");
		// file.getParentFile().mkdirs();
		// PrintWriter out = new PrintWriter(file);
		// out.println(privateKey);
		// out.close();
		
	}
	
	//converts a BigInteger number to base 58
	public static String toBase58(BigInteger bignumber){
		
		String base58Num="";
		BigInteger NUM58= new BigInteger("58");
		BigInteger NUM0= new BigInteger("0");
		int newDigit;
		char newChar;
		while (bignumber.compareTo(NUM0)>0){			
			newDigit=(bignumber.mod(NUM58)).intValue();
			switch (newDigit) {				
				
				case 0:  newChar = '1';
						 break;
				case 1:  newChar = '2';
						 break;
				case 2:  newChar = '3';
						 break;
				case 3:  newChar = '4';
						 break;
				case 4:  newChar = '5';
						 break;
				case 5:  newChar = '6';
						 break;
				case 6:  newChar = '7';
						 break;
				case 7:  newChar = '8';
						 break;
				case 8:  newChar = '9';
						 break;
				case 9: newChar = 'A';
						 break;
				case 10: newChar = 'B';
						 break;
				case 11: newChar = 'C';
						 break;
				case 12: newChar = 'D';
						 break;
				case 13: newChar = 'E';
						 break;
				case 14: newChar = 'F';
						 break;
				case 15: newChar = 'G';
						 break;
				case 16: newChar = 'H';
						 break;
				case 17: newChar = 'J';
						 break;
				case 18: newChar = 'K';
						 break;
				case 19: newChar = 'L';
						 break;
				case 20: newChar = 'M';
						 break;
				case 21: newChar = 'N';
						 break;
				case 22: newChar = 'P';
						 break;
				case 23: newChar = 'Q';
						 break;
				case 24: newChar = 'R';
						 break;
				case 25: newChar = 'S';
						 break;
				case 26: newChar = 'T';
						 break;
				case 27: newChar = 'U';
						 break;
				case 28: newChar = 'V';
						 break;
				case 29: newChar = 'W';
						 break;
				case 30: newChar = 'X';
						 break;
				case 31: newChar = 'Y';
						 break;
				case 32: newChar = 'Z';
						 break;
				case 33: newChar = 'a';
						 break;
				case 34: newChar = 'b';
						 break;
				case 35: newChar = 'c';
						 break;
				case 36: newChar = 'd';
						 break;
				case 37: newChar = 'e';
						 break;
				case 38: newChar = 'f';
						 break;
				case 39: newChar = 'g';
						 break;
				case 40: newChar = 'h';
						 break;
				case 41: newChar = 'i';
						 break;
				case 42: newChar = 'j';
						 break;
				case 43: newChar = 'k';
						 break;
				case 44: newChar = 'm';
						 break;
				case 45: newChar = 'n';
						 break;
				case 46: newChar = 'o';
						 break;
				case 47: newChar = 'p';
						 break;
				case 48: newChar = 'q';
						 break;
				case 49: newChar = 'r';
						 break;
				case 50: newChar = 's';
						 break;
				case 51: newChar = 't';
						 break;
				case 52: newChar = 'u';
						 break;
				case 53: newChar = 'v';
						 break;
				case 54: newChar = 'w';
						 break;
				case 55: newChar = 'x';
						 break;
				case 56: newChar = 'y';
						 break;
				case 57: newChar = 'z';
						 break;				 
				default: newChar= ' ';
						 break;						 
			}
			base58Num=newChar+base58Num;
			bignumber=bignumber.divide(NUM58);
			
		}
		return base58Num;
	}

	//sha-256 code
	static String sha256(String input) throws NoSuchAlgorithmException {
		byte[] in = hexStringToByteArray(input);
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(in);
		StringBuffer sb = new 
		StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
			return sb.toString();
	}
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
			+ Character.digit(s.charAt(i+1), 16));
		}
			return data;
	} 
}
