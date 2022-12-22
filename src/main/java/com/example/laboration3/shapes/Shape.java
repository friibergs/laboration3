package com.example.laboration3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    private final double xPosition;

    private final double yPosition;

    private Color color;

    private double size;

    public Shape(double xPosition, double yPosition, Color color, double size){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
        this.size = size;

    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }

    public Color getColor() {
        return color;
    }

    public double getSize() {
        return size;
    }

    public abstract void drawShape(GraphicsContext context);

    public abstract boolean containing(double findX, double findY);

    public static Shape createShape(ShapeType type, double xPosition, double yPosition, Color color, double size){
        return switch(type) {
            case CIRCLE -> new Circle(xPosition,yPosition,color,size);
            case SQUARE -> new Square(xPosition,yPosition,color,size);

        };
    }

    public abstract String toSVG();
}
