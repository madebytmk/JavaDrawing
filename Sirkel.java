import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Sirkel extends Shapes {
    public Sirkel(double x, double y, ColorPicker colorPicker, ColorPicker colorPicker2) {
        super(x, y, colorPicker, colorPicker2);
    }

    @Override
    protected Shape createShape(double x, double y) {
        return new Circle(x, y, 0);
    }
}