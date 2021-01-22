package ex03_interface;

public class Rcet implements Shape {
	private int width, height;
	
	public Rcet(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public String getName() {
		return "사각형";
	}
	@Override
	public double getArea() {
		return width * height;
	}

}
