import java.lang.*;
public class distanceGPS{
	public static void main(String[] args){
		
		double phi1=degToRad(40.6892);
		double lambda1=degToRad(74.0445);
		double phi2=degToRad(48.8530);
		double lambda2=(2*Math.PI)-degToRad(2.3499);
		double radiusOfEarth = 6371;
		
		System.out.println(distance(phi1,phi2,lambda1,lambda2,radiusOfEarth)+" km");
	}
	
	//converts degree to radians
	public static double degToRad(double angle){
		return (angle*Math.PI)/180;
	}
	//calculates the haversine of an angle in radians
	public static double havesine(double theta){
		return (1-Math.cos(theta))/2;		
	}
	//calculates the distance between tow points on a sphere given Latitude/Longitude and sphere radius.
	public static double distance(double p1, double p2, double l1, double l2, double r){
		return 2*r*Math.asin(Math.sqrt(havesine(p2-p1)+(Math.cos(p1)*Math.cos(p2)*havesine(l2-l1))));
	}
}