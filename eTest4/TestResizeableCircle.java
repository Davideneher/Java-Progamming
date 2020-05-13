public class TestResizeableCircle {
	
	public static void main(String[] args) {
		ResizeableCircle resizedCircle = new ResizeableCircle(100.0);
		resizedCircle.resize(10);
		System.out.printf("Perimeter of the circle is: %.2f", resizedCircle.getPerimeter());
		System.out.println();
		System.out.printf("Area of the resized circle is: %.2f", resizedCircle.getArea());
	}
	
}
