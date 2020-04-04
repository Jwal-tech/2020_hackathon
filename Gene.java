
import java.util.Objects;
public class Gene {
     
	private int x;
	private int y;
	
    
	public Gene(int x, int y) {
		this.x =x;
		this.y =y;
	} // create gene with x and y values
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	double distanceBetweenPoints(Gene g) {
		double distance;
		distance = Math.sqrt(Math.pow(this.getX()-g.getX(), 2) + Math.pow(this.getY()- g.getY(), 2)); // distance between two coordinates equals square root of the difference between two x points squared plus the difference betwen two y points squared
		return distance;
	} 
	
	@Override
	public String toString() {
		String geneStats = "";
		
		geneStats = "x = " + x + ", y = " + y;
		return geneStats;
	}
	
	
	public int hashCode() {
		int hash;
		hash = Objects.hash(this.x, this.y);
		return hash;
		
	}
	
	
	
}
