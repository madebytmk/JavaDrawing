import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Rektangel extends Shapes {
    public Rektangel(double x, double y, ColorPicker colorPicker, ColorPicker colorPicker2) {
        super(x, y, colorPicker, colorPicker2);
    }

    @Override
    protected Shape createShape(double x, double y) {
        return new Rectangle(x, y, 0, 0);
    }
}