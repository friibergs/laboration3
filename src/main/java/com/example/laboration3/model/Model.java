package com.example.laboration3.model;

import com.example.laboration3.shapes.Shape;
import com.example.laboration3.shapes.ShapeType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

public class Model {

    ObjectProperty<ShapeType> chosenShapeType = new SimpleObjectProperty<>();
    ObservableList<Shape> shapesObsList = FXCollections.observableArrayList();
    ObjectProperty<Color> choseColor = new SimpleObjectProperty<>();
    DoubleProperty createXPosition = new SimpleDoubleProperty();
    DoubleProperty createYPosition = new SimpleDoubleProperty();
    DoubleProperty createSize = new SimpleDoubleProperty();

    public ObservableList<Shape> getShapesObsList() {
        return shapesObsList;
    }

    public double getCreateXPosition() {
        return createXPosition.get();
    }

    public void setCreateXPosition(double createXPosition){
        this.createXPosition.set(createXPosition);
    }

    public double getCreateYPosition() {
        return createYPosition.get();
    }

    public void setCreateYPosition(double createYPosition) {
        this.createYPosition.set(createYPosition);
    }

    public double getCreateSize() {
        return createSize.get();
    }

    public void setCreateSize(double createSize) {
        this.createSize.set(createSize);
    }

    public DoubleProperty createSizeProperty() {
        return createSize;
    }

    public ShapeType getChosenShapeType() {
        return chosenShapeType.get();
    }

    public void setChosenShapeType(ShapeType chosenShapeType) {
        this.chosenShapeType.set(chosenShapeType);
    }

    public Color getChoseColor() {
        return choseColor.get();
    }

    public void setChoseColor(Color choseColor) {
        this.choseColor.set(choseColor);
    }

    public ObjectProperty<Color> choseColorProperty() {
        return choseColor;
    }

    public void addShape() {
        Shape shape = Shape.createShape(getChosenShapeType(), getCreateXPosition(), getCreateYPosition(), getChoseColor(), getCreateSize());
        shapesObsList.add(shape);

    }
    public void undo(){
        shapesObsList.remove(shapesObsList.size()-1);
    }


    public void selected(double xPosition, double yPosition) {
        for (Shape s :
                shapesObsList) {
            if (s.containing(xPosition, yPosition)) {
                shapesObsList.remove(s);
                setCreateXPosition(s.getxPosition());
                setCreateYPosition(s.getyPosition());
                setCreateSize(getCreateSize());
                setChoseColor(getChoseColor());
                addShape();
            }

        }

    }



}
