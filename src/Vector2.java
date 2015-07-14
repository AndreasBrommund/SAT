
public class Vector2 {
	double x;
	double y; 
	double length;
	public Vector2(double x,double y) {
		this.x = x; 
		this.y = y;
		
		length = Math.sqrt(x*x+y*y);
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+",l="+length+")";
	}
	
	public Vector2 nor(){
		return new Vector2(x/length, y/length);
	}
	
	public double dot(Vector2 v){
		return x*v.x+y*v.y;
	}
}
