/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism
{
	public RectangularPrism(double height) {
		super(height);
		
	}
	private int length;
	private int width;
	
	public double getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public double calcAreaOfBase(double length, double height) {
		return length*height;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public double calcPerimeter(double length, double width, double height) {
		return 2*(length+ width+ height);
	}
	
	
}

