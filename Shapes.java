import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import java.util.List;

public class Shapes extends Pane {
    private List<Shape> shapes = new ArrayList<>();
    private ColorPicker colorPicker;
    private ColorPicker colorPicker2;
    private double startX, startY;
    private Shape currentShape;

    public Shapes(double width, double height, ColorPicker colorPicker, ColorPicker colorPicker2) {
        this.colorPicker = colorPicker;
        this.colorPicker2 = colorPicker2;

        setMinWidth(width);
        setMinHeight(height);



        setOnMousePressed(event -> {
            if (isWithinBoundary(event.getX(), event.getY())) {
                startX = event.getX();
                startY = event.getY();
                currentShape = createShape(startX, startY);
                currentShape.setStroke(colorPicker.getValue());
                currentShape.setFill(colorPicker2.getValue());
                getChildren().add(currentShape);
                shapes.add(currentShape);
            }
        });

        setOnMouseDragged(event -> {
            if (isWithinBoundary(event.getX(), event.getY()) && currentShape != null) {
                if (currentShape instanceof Rectangle) {
                    Rectangle rectangle = (Rectangle) currentShape;
                    double endX = event.getX();
                    double endY = event.getY();
                    double x = Math.min(startX, endX);
                    double y = Math.min(startY, endY);
                    double rectWidth = Math.abs(endX - startX);
                    double rectHeight = Math.abs(endY - startY);
                    rectangle.setX(x);
                    rectangle.setY(y);
                    rectangle.setWidth(rectWidth);
                    rectangle.setHeight(rectHeight);
                } else if (currentShape instanceof Circle) {
                    Circle circle = (Circle) currentShape;
                    double endX = event.getX();
                    double endY = event.getY();
                    double radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                    circle.setRadius(radius);
                }
            }
        });

        setOnMouseReleased(event -> {
            currentShape = null;
        });
    }
    

    private boolean isWithinBoundary(double x, double y) {
        return x >= 0 && x <= getWidth() && y >= 0 && y <= getHeight();
    }

    protected Shape createShape(double x, double y) {
        return null; 
    }
}