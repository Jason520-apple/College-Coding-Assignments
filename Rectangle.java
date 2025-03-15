// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes


public class Rectangle extends Shape { // child class of Shape

	protected double width, height;
	
	
	// Rectangle constructor
	public Rectangle(double x, double y, double width, double height) {
		super.x = x;
		super.y = y;
		this.width = width;
		this.height = height;
	}
	

	// implementing abstract methods
	@Override
	public double getArea() {
		//area is width multiplied by height
		double area = width * height;
		return area;	
	}

	@Override
	public double getPerimeter() {
		//perimeter is width + width + height + height
		double perimeter = width + width + height + height;
		return perimeter;	
	}


	//override the parent's abstract method for drawShape
	
	//Drawing shape: Make it fairly detailed: for instance, it should specify the
	//upper-left coordinates and the various parameters that make up the shape and specify the color
	//and such
	@Override
	public void drawShape() {
		//For now the drawing methods will simply write text to the console. 
		System.out.println("\nDrawing Rectangle...\n\n");
		System.out.println("This rectangle has a width of " + width + ", and a height of " + height +
							". The area of this rectangle is " + getArea() + ", and the perimeter is " + getPerimeter() + ".");
		
		System.out.println("The upper left coordinates of this rectangle are: (" + x + ", " + y + ").");
		
		System.out.println("The rectangle is the color " + super.getColor()); //color
		
		//call the super method to determine if this shape is filled
		if (super.getFill() == Shape.SHAPE_SET_FILL) {
			System.out.println("\nThe rectangle is filled.");
		}
		else { //this means it is not filled, therefore there is no color
			System.out.println("\nThe rectangle is not filled.");
		}
	}
	
	
	
}
