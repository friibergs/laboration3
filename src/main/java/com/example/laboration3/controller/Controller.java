package com.example.laboration3.controller;

import com.example.laboration3.Svg;
import com.example.laboration3.model.Model;
import com.example.laboration3.shapes.ShapeType;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import com.example.laboration3.shapes.*;

import java.util.ConcurrentModificationException;

import static com.example.laboration3.shapes.ShapeType.CIRCLE;
import static com.example.laboration3.shapes.ShapeType.SQUARE;

public class Controller {

    public Canvas canvas;

    public GraphicsContext context;

    public Color color;

    public ColorPicker colorPicker = new ColorPicker();

    ShapeType defaultShape = CIRCLE;

    public ToggleButton selectBtn;

    public Slider slider;

    Model model = new Model();


    public void initialize() {
        context = canvas.getGraphicsContext2D();
        colorPicker.valueProperty().bindBidirectional(model.choseColorProperty());
        slider.valueProperty().bindBidirectional(model.createSizeProperty());
        model.getShapesObsList().addListener(this::listChanged);
    }

    private void listChanged(Observable observable) {
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape s : model.getShapesObsList()) {
            s.drawShape(context);
        }
    }

    public void setColorPicker() {
        colorPicker.setOnAction(e -> {
            color = colorPicker.getValue();
        });
    }


//    public void setColorPicker(ColorPicker colorPicker) {
//        this.colorPicker = colorPicker;
//    }

    public void circleBtn() {
        defaultShape = CIRCLE;
    }


    public void squareBtn() {
        defaultShape = SQUARE;
    }


    public void undo() {
        model.undo();
    }

    public boolean select() {
        BooleanProperty select = selectBtn.selectedProperty();
        BooleanProperty normal = new SimpleBooleanProperty(false);
        normal.bind(select);
        return select.getValue();
    }

    public void placeOnCanvas(MouseEvent mouseEvent){

        if (select()) {
            try {
                model.selected(mouseEvent.getX(), mouseEvent.getY());
            } catch (ConcurrentModificationException ignored) {
                System.out.println("Error. Concurrent modification ignored");
            }
        } else {

            model.setChoseColor(colorPicker.getValue());
            model.setChosenShapeType(defaultShape);
            model.setCreateXPosition(mouseEvent.getX());
            model.setCreateYPosition(mouseEvent.getY());
            model.addShape();
        }
    }

    public void save() {
        Svg.save(model);
    }

}
