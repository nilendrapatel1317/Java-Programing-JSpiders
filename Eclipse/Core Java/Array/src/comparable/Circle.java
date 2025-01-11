package comparable;

public class Circle implements Comparable {
	int radius;
	public Circle(int r) {
		radius=r;
	}
	
	@Override
	public String toString() {
		return "radius = "+radius;
	}

	@Override
	public int compareTo(Object o) {
		
		return this.radius - ((Circle) o).radius;
	}
	
}
