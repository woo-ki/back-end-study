package ex03_interface;

public class Triangle implements Shape {
	private int width, height;
	
	public Triangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String getName() {
		return "삼각형";
	}

	@Override
	public double getArea() {
		return width * height / 2;
	}

}
