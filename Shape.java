// Jason Vo
// OCCC Spring 2025
// Advanced Java
// Unit 4 Homework - Shapes



//imported class for color
import java.awt.Color;

public abstract class Shape {

	//protected variables
	protected double x, y;
	protected Color c;
	protected boolean fill;
	
	// constants or static variables
	public static boolean SHAPE_DEFAULT_FILL = false;
	public static Color SHAPE_DEFAULT_COLOR = Color.gray;
	public static boolean SHAPE_SET_FILL = true; // use with setFill
	public static boolean SHAPE_SET_OUTLINE = false; // use with setFill
	
	
	// default constructor, sets color and fill to default
	protected Shape() {
		c = SHAPE_DEFAULT_COLOR;
		fill = SHAPE_DEFAULT_FILL;
	}

	// getters and setters
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public Color getColor() {
		return c;
	}


	public void setColor(Color c) {
		this.c = c;
	}

	
	public boolean getFill() {
		return fill;
	}


	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	
	// abstract methods that will calculate area, perimeter, and draw shape (italics in the UML diagram denotes this)
	// the child classes will have to implement this using differing methods, since calculating perimeter and area differs depending on the shape
	public abstract double getArea();
	
	public abstract double getPerimeter();
	
	public abstract void drawShape();
	
	
}
