import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.ColorPicker;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import java.util.List;
import java.util.ArrayList;


public class index extends Application {

    private Button linje, rektangel, sirkel, tekst;
    public Label figurType;
    private Label fyll = new Label("FyllFarge:");
    private Label stroke = new Label("LinjeFarge:");
    ColorPicker colorPicker = new ColorPicker();
    ColorPicker colorPicker2 = new ColorPicker();
    private String currentShapeType = "Rektangel"; 
    BorderPane ui = new BorderPane();
    //private List<Shapes> allShapes = new ArrayList<>();
  



    public void start(Stage vindu) {

        colorPicker.setOnAction(e -> handleColorSelection(e));
        colorPicker2.setOnAction(e -> handleColorSelection(e));


        
        ui.setPadding(new Insets(10, 10, 10, 10));

        BackgroundFill backgroundFill = new BackgroundFill(Color.GRAY, null, null);
        Background background = new Background(backgroundFill);

        VBox figurer = new VBox();
        figurer.setSpacing(40);
        figurer.setBackground(background);
        figurer.setPrefWidth(120);
        figurer.setAlignment(Pos.TOP_CENTER);
        figurer.setPadding(new Insets(10, 10, 10, 10));

        VBox valgtFigur = new VBox();
        valgtFigur.setSpacing(40);
        valgtFigur.setBackground(background);
        valgtFigur.setPrefWidth(120);
        valgtFigur.setAlignment(Pos.TOP_CENTER);
        valgtFigur.setPadding(new Insets(10, 10, 10, 10));

        figurType = new Label("FigurType:" + "\n" + "Ingen figur valgt");
        figurType.setTextFill(Color.WHITE);


        fyll.setTextFill(Color.WHITE);
        stroke.setTextFill(Color.WHITE);
        stroke.setPadding(new Insets(500, 0, 0, 0));


        linje = new Button("/");
        linje.setOnAction(e -> behandleKlikk(e));
        rektangel = new Button("▮");
        rektangel.setOnAction(e -> behandleKlikk(e));
        sirkel = new Button("●");
        sirkel.setOnAction(e -> behandleKlikk(e));
        tekst = new Button("Tekst");
        tekst.setOnAction(e -> behandleKlikk(e));

        figurer.getChildren().addAll(linje, rektangel, sirkel, tekst);
        valgtFigur.getChildren().addAll(figurType, stroke, colorPicker, fyll, colorPicker2);

        ui.setLeft(figurer);
        ui.setRight(valgtFigur);

        Scene scene = new Scene(ui, 1900, 1080);
        vindu.setTitle("Tegneprogram");
        vindu.setScene(scene);
        vindu.setResizable(false);
        vindu.setX(100);
        vindu.show();
        vindu.setMaximized(true);


    
      



    

    }


private Shapes createShapeObject(double x, double y) {
    if (currentShapeType.equals("Rektangel")) {
        Rektangel rektangel = new Rektangel(x, y, colorPicker, colorPicker2);
        //allShapes.add(rektangel);
        return rektangel;
    } else if (currentShapeType.equals("Sirkel")) {
        Sirkel sirkel = new Sirkel(x, y, colorPicker, colorPicker2);
        //allShapes.add(sirkel);
        return sirkel;
    }
    return null;
}




    public void handleColorSelection(ActionEvent event) {
    Color selectedColor = colorPicker.getValue();
    Color selectedColor2 = colorPicker2.getValue();

}

    public static void main(String[] args) {
        launch(args);
    }



public void behandleKlikk(ActionEvent event) {
    if (event.getSource() == rektangel) {
        currentShapeType = "Rektangel";
        figurType.setText("FigurType:" + "\n" + currentShapeType);
    } else if (event.getSource() == linje) {
        currentShapeType = "Linje";
        figurType.setText("FigurType:" + "\n" + currentShapeType);
    } else if (event.getSource() == sirkel) {
        currentShapeType = "Sirkel";
        figurType.setText("FigurType:" + "\n" + currentShapeType);
    } else if (event.getSource() == tekst) {
        currentShapeType = "Tekst";
        figurType.setText("FigurType:" + "\n" + currentShapeType);
    }

    Shapes newShape = createShapeObject(0, 0);
    ui.setCenter(newShape);
    System.out.println(newShape);

}
}