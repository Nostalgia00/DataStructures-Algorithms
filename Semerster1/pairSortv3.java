import java.lang.Math;
public class pairSortv3{
	public static void main(String[] args){
		
		String[] sArray = 
{"7270536038336708566", "8019217342518227357", "3040884611156577620", "4971410678527411098", "183064013267932758", 
"8056584603037925167", "1899884129638764508", "5128941762697709445", "5047244487910064394", "3305601720113745382", 
"5776953008539814370", "34988082947722169", "7434345681532331612", "5407786886759427803", "688068291500036320", 
"2068510150417278708", "1868790318480929054", "3425404376196216488", "1131190712360422749", "102967645096808272", 
"1445942735952374406", "8456737838228485082", "7623544032966572081", "3942629391233399085", "75109850685511728", 
"223515536869223609", "764673323466830185", "2792331077502901882", "8043871486090449356", "8027891460874623856", 
"9035205129603316628", "5210176758109223792", "6369027410439876015", "719764136449271247", "6275216998605832028", 
"7518974182407464286", "8228098362075889963", "4364500170274364383", "5160900320056121570", "3574188741140445768", 
"3799725687163235416", "8971054323076859594", "303947614746485290", "4072768654844778108", "422948319988286530", 
"228169257627773589", "4695919214544378987", "5634695221137989240", "2134479954298742138", "7591363728605668117", 
"227743280468209272", "3815359581987719752", "240831188333789404", "1682051551566226", "7028911732181187415", 
"8534901095561461575", "604981729275990578", "4379371367686136078", "2561184379973031673", "3251231714574439892", 
"8507596701451728093", "1479176915196229414", "4596908701725205546", "7434222118200184219"};
		long smallestResult=Long.MAX_VALUE;
		long testNumber = Long.parseLong("1000000000000000");// Useful for getting a sence of relative number scale
		int[] terArray = new int[sArray.length];
		long[] array = new long[sArray.length];
		for(int i=0;i<array.length;i++){
			array[i]=Long.parseLong(sArray[i]);
			if(array[i]<smallestResult){
				smallestResult=array[i];
			}
			System.out.println(array[i]/testNumber);
		}
		//Bubblesort
		for(int j =array.length;j>0;j--){
			for(int i=1;i<j;i++){
				if(array[i-1]<array[i]){
					swap(i-1,i,array);
				}
			}
		}
		System.out.println("\n**********\n\n");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]/testNumber);
		}
		
		String sTer = "";
		long sum =array[0];
		terArray[0]=0;
		for(int i=1;i<array.length;i++){
			if(Math.abs(sum+array[i])<Math.abs(sum-array[i])){
				terArray[i]=0;
				sum+=array[i];
			}
			else{
				terArray[i]=1;
				sum-=array[i];
			}
		}
		smallestResult=sum;
		sTer="";
		for(int i=0;i<terArray.length;i++){
			sTer += ""+terArray[i];
		}	
		
		System.out.println("The smallest result was : "+Math.abs(smallestResult/testNumber)+"\nThe combination was : "+sTer);
		
	}
	public static void randomiseArray(int[] randoArray){
		
		int temp;
		int tempIndex;
		for(int i=0;i<randoArray.length;i++){
			tempIndex = (int)Math.floor(Math.random()*randoArray.length);
			temp=randoArray[i];
			randoArray[i]=randoArray[tempIndex];
			randoArray[tempIndex]=temp;
		}
	}
	public static void swap(int first, int second, long[] array){
		long temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
	
}