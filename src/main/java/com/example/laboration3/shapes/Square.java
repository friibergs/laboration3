package com.example.laboration3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Square extends Shape {
    public Square(double xPosition, double yPosition, Color color, double size) {
        super(xPosition, yPosition, color, size);
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillRect(getxPosition(), getyPosition(), getSize(), getSize());
    }

    @Override
    public boolean containing(double findX, double findY) {
        Rectangle shape = new Rectangle(getxPosition(), getyPosition(), getSize(), getSize());
        return shape.contains(findX, findY);
    }

    @Override
    public String toSVG() {
        String color = "#" + getColor().toString().substring(2,10);
        return "<rect x=\"" + getxPosition() + "\" y=\"" + getyPosition() + "\" width=\"" + getSize() + "\" height=\"" + getSize() + "\" fill=\"" + color + "\" />";
    }


}
