package com.day28;

interface Shape{
	void draw();
}
class Circle implements Shape{
	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}
}
class Square implements Shape{
	@Override
	public void draw() {
		System.out.println("Drawing a Square");
	}
}
class Rectangle implements Shape{
	@Override
	public void draw() {
		System.out.println("Drawing a Rectangle");
	}
}
class ShapeFactory{
	public Shape getShape(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		return null;
	}
}

public class FactoryPattern {
	
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape2.draw();
		Shape shape3 = shapeFactory.getShape("RECTANGLE");
		shape3.draw();
		

	}

}
