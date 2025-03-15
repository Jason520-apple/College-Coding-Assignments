// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes



public class Circle extends Ellipse { //a circle "is-a" ellipse

	//constructor only, because inherits all other methods of parent classes
	public Circle(double x, double y, double r) {
		super(x,y,r,r); // passing in r twice because the formulas/methods for finding area and perimeter are found in parent classes
	}
	
}
