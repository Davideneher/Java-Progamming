public class Circle implements GeometricObject {
	protected double radius = 1.0;
	
	public Circle (double radius) {
		this.radius = radius;
	}
	
	public double getPerimeter() {
		double perimeter = (2 * Math.PI * radius);
		return perimeter;
	}

	public double getArea() {
		double area = (Math.PI * radius * radius);
		return area;
	}	

}
