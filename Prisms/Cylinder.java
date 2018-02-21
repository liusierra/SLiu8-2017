/* Write this concrete (non-abstract) class called Cylinder that extends Prism.  
 * It has a private field (radius) and inherits its height from its superclass, Prism 
 *    (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class Cylinder extends Prism{
private int width;
private int length;

public Cylinder(double height, int i) {
		super(height);
		// TODO Auto-generated constructor stub
	}

@Override
public double calcAreaOfBase() {
	// TODO Auto-generated method stub
	return width*length;
}

@Override
public double calcPerimeter() {
	// TODO Auto-generated method stub
	return 2*(length+ width+ height);
}
	
	
	
	
}
