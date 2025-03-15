// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes



public class Ellipse extends Shape {
	
	//protected variable, meaning subclasses of this can access it (circle)
	protected double radius1, radius2;
	
	//constructor
	public Ellipse(double x, double y, double r1, double r2) {
		
		super.x = x;
		super.y = y;
		
		radius1 = r1;
		radius2 = r2;
	}

	@Override
	public double getArea() {
		// area of an ellipse is pi * radius1 * radius2
		double area = Math.PI * (radius1 * radius2);
		return area;
	}

	@Override
	public double getPerimeter() {
		//perimeter formula found from: https://www.geeksforgeeks.org/how-to-find-the-perimeter-and-area-of-ellipse/
		double perimeter = 2.0 * Math.PI * Math.sqrt(((radius1* radius1) + (radius2 * radius2)) / 2.0);
		return perimeter;
	}

	//override the parent's abstract method for drawShape
	
	//Drawing shape: Make it fairly detailed: for instance, it should specify the
	//upper-left coordinates and the various parameters that make up the shape and specify the color
	//and such
	@Override
	public void drawShape() {
		//For now the drawing methods will simply write text to the console. 
		System.out.println("\nDrawing Ellipse...\n");
		System.out.println("This ellipse has a radius 1 of " + radius1 + " and a radius 2 of " + radius2 + 
							". The area of this ellipse is " + getArea() + " and the perimeter is " + getPerimeter() + ".");
		
		System.out.println("The upper left coordinates of this ellipse are: (" + x + ", " + y + ").");
		
		System.out.println("The ellipse is the color " + super.getColor()); //color
		
		//call the super method to determine if this shape is filled
		if (super.getFill() == Shape.SHAPE_SET_FILL) {
			System.out.println("\nThe ellipse is filled.");
		}
		else { //this means it is not filled, therefore there is no color
			System.out.println("\nThe ellipse is not filled.");
		}
	
	}
	
}
