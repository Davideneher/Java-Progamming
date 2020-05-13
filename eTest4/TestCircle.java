public class TestCircle {

	public static void main(String[] args) {
		Circle myCircle = new Circle(100.0);
		System.out.printf("Perimeter of the circle is: %.2f", myCircle.getPerimeter());
		System.out.println();
		System.out.printf("Area of the circle is: %.2f", myCircle.getArea());
		
	}
}
