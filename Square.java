// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes


public class Square extends Rectangle { // a square "is a" rectangle, technically, so can share drawShape function

	//constructor only code, since the code required to calculate area and perimeter are same between the rectangle and square
	public Square(double x, double y, double width) {
		super(x, y, width, width); //using rectangle (parent) constructor, passing in width twice for height as well since a square has same width and height
	}
}
