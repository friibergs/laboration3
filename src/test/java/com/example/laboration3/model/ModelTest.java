package com.example.laboration3.model;

import com.example.laboration3.shapes.Circle;
import com.example.laboration3.shapes.ShapeType;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = new Model();

    @Test
    void testIfShapeIsAdded(){
        model.setChosenShapeType(ShapeType.CIRCLE);
        model.setCreateXPosition(100.0);
        model.setCreateYPosition(100.0);
        model.setChoseColor(Color.PURPLE);
        model.setCreateSize(10.0);
        model.addShape();
        assertEquals(1, model.getShapesObsList().size());
    }

    @Test
    void testUndoMethod(){
        model.setChosenShapeType(ShapeType.CIRCLE);
        model.setCreateXPosition(100.0);
        model.setCreateYPosition(100.0);
        model.setChoseColor(Color.PURPLE);
        model.setCreateSize(10.0);
        model.addShape();
        model.undo();
        assertEquals(0,model.getShapesObsList().size());
    }

}