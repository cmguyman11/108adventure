package bunnyworld;

import java.util.ArrayList;

public class Shape {
	private String name;
	
	// what should be displayed
	private String text;
	private String image;
	
	private ArrayList<String> clauses;
	
	// coordinates on the screen
	private int x;
	private int y;
	
	private boolean hidden;
	private boolean moveable;
	
	public Shape(String name, int x, int y, String script) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.clauses = parseScript(script);
		hidden = false;
		moveable = true;
	}
	
	public String getName() { return name; }
	
	// Guessing another class will reset the position
	public int getX() { return x;}
	public int getY() { return y;}
	public void setX(int x) { this.x = x;}
	public void setY(int y) { this.y = y;}
	
	public void setImage(String image) { this.image = image; }
	public void setText(String text) { this.text = text; }
	
	public void setScript(String script) { 
		this.clauses = parseScript(script); 
		}
	
	// Knows how to draw itself, grey rectangle if no picture
	public void draw() {
		if (text.equals("")) {
			// scale image to size, using x and y
			// drawImage
		} else {
			// drawText
		}
	}
	
	private ArrayList<String> parseScript(String script) {
		return new ArrayList<String>();
	}
	
}
