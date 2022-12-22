package com.example.laboration3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {
    public Circle(double xPosition, double yPosition, Color color, double size) {
        super(xPosition, yPosition, color, size);
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(getxPosition() - getSize() / 2, getyPosition() - getSize() / 2, getSize(), getSize());
    }

    @Override
    public boolean containing(double findX, double findY) {
        double x = findX - getxPosition();
        double y = findY - getyPosition();
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance <= getSize() / 2;

    }

    @Override
    public String toSVG() {
        String color = "#" + getColor().toString().substring(2,10);
        return "<circle cx=\""+ (getxPosition()-(getSize()/2)) + "\" cy=\"" +(getyPosition()-(getSize()/2)) + "\" r=\"" +getSize() + "\" fill=\""+ color + "\"/>";

    }
}
