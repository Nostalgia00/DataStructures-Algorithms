public class Link{
	public int data;
	public Link next;
	public Link previous;
	public Link(int datain){
		data = datain;    
	}
	public void displayLink(){
		System.out.println(data);
	}
}