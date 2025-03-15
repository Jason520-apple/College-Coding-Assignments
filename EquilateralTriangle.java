// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes


public class EquilateralTriangle extends Shape {

	// the user will provide the size of one side, which is the same for all the other sides since this is an equilateral triangle
	protected double side;
	
	// constructor
	public EquilateralTriangle(double x, double y, double side) {
		super.x = x;
		super.y = y;
		this.side = side;
	}
	
	
	//area and perimeter methods
	
	@Override
	public double getArea() {
		double area = (Math.sqrt(3) / 4) * Math.pow(side, 2);
		return area; // formula for area of equilateral triangle is the sqrt of 3 divided by 4 multiplied by the side's length squared
	}


	@Override
	public double getPerimeter() {
		double perimeter = side + side + side;
		return perimeter;
	}

	
	//displaying the equilateral triangle

	@Override
	public void drawShape() {
		//For now the drawing methods will simply write text to the console. 
		System.out.println("\nDrawing Equilateral Triangle...\n");
		System.out.println("This equilateral triangle has a side length of " + side + ". The area of this triangle is " + getArea() + " and the perimeter is " + getPerimeter() + ".");
				
		System.out.println("The upper left coordinates of this triangle are: (" + x + ", " + y + ").");
				
		System.out.println("The triangle is the color " + super.getColor()); //color
				
		//call the super method to determine if this shape is filled
		if (super.getFill() == Shape.SHAPE_SET_FILL) {
			System.out.println("\nThe triangle is filled.");
		}
		else { //this means it is not filled, therefore there is no color
			System.out.println("\nThe triangle is not filled.");
		}
	}
	
	
	
}
